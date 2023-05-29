import { signIn, useSession } from 'next-auth/react';
import { useRouter } from 'next/router'

export default function Products() {

  const router = useRouter();

  const { data: session } = useSession();

  if (!session?.user) {
    return (
      <>
        Não autenticado <br />
        <button onClick={() => signIn('github')}>Entrar</button>
      </>
    )
  }
  
  const { id } = router.query;
  return (
    <div>
      <h1>Products {id}</h1>
    </div>
  )
}
