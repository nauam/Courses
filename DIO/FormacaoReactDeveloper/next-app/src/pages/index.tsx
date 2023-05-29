import { useSession, signIn, signOut } from "next-auth/react"

export default function Home() {
  const { data: session } = useSession()

  console.log(session);

  if (session?.user) {
    return (
      <>
        <img src={session?.user?.image} /> <br />
        Autenticado como {session?.user?.email} <br />
        <button onClick={() => signOut('github')}>Sair</button>
      </>
    )
  }

  return (
    <>
      Não autenticado <br />
      <button onClick={() => signIn('github')}>Entrar</button>
    </>
  )
}
