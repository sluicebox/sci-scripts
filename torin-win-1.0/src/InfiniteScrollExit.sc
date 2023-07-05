;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50901)
(include sci.sh)
(use Main)
(use ScrollExit)
(use PolyPath)
(use Grooper)

(public
	ShortestWalk 0
	WrapEgoRight 1
	WrapEgoLeft 2
	CheckSawCondition 3
	CheckRosinCondition 4
)

(local
	xDest = -1
	yDest = -1
)

(procedure (CheckSawCondition)
	(if
		(and
			((ScriptID 64017 0) test: 168) ; oFlags
			((ScriptID 64017 0) test: 169) ; oFlags
			((ScriptID 64017 0) test: 162) ; oFlags
			((ScriptID 64017 0) test: 206) ; oFlags
		)
		(if (gTheDoits contains: (ScriptID 50900 7)) ; oCarpenterActionCuer
			(gTheDoits delete: (ScriptID 50900 7)) ; oCarpenterActionCuer
		)
		(if (gTheDoits contains: (ScriptID 50900 8)) ; oCarpenterActionSeenCuer
			(gTheDoits delete: (ScriptID 50900 8)) ; oCarpenterActionSeenCuer
		)
		(gTheDoits add: (ScriptID 50900 9)) ; oCarpenterVanishCuer
		(return 1)
	else
		(return 0)
	)
)

(procedure (CheckRosinCondition)
	(if (and ((ScriptID 64017 0) test: 172) ((ScriptID 64017 0) test: 167)) ; oFlags, oFlags
		(gTheDoits add: (ScriptID 50900 10)) ; oAcrobatsVanishCuer
		(return 1)
	else
		(return 0)
	)
)

(procedure (ShortestWalk nX nY oCueParm &tmp oCuee)
	(if (> argc 2)
		(= oCuee oCueParm)
	else
		(= oCuee 0)
	)
	(if (<= (Abs (- nX (gEgo x:))) 1580)
		(= xDest nX)
		(= yDest nY)
	else
		(if (< (gEgo x:) 1580)
			(= xDest (- nX 3160))
		else
			(= xDest (+ nX 3160))
		)
		(= yDest nY)
	)
	(gEgo setMotion: PolyPath xDest yDest oCuee)
)

(procedure (WrapEgoRight &tmp oMover oWhoToCue oldX oldY)
	(if
		(and
			(not (= oMover (gEgo mover:)))
			((gEgo looper:) isMemberOf: Grooper)
		)
		(= oMover ((gEgo looper:) oldMover:))
	)
	(if (and (!= xDest -1) oMover (>= (oMover x:) (gEgo x:)))
		(-= xDest 3160)
		(= oWhoToCue (oMover caller:))
		(gEgo posn: (- (gEgo x:) 3160) (gEgo y:))
		(gEgo setMotion: PolyPath xDest yDest oWhoToCue)
	else
		(gEgo posn: (- (gEgo x:) 3160) (gEgo y:))
		(if oMover
			(= oldX (oMover x:))
			(= oldY (oMover y:))
			(= oWhoToCue (oMover caller:))
			(gEgo setMotion: PolyPath oldX oldY oWhoToCue)
		)
	)
)

(procedure (WrapEgoLeft &tmp oMover oWhoToCue oldX oldY)
	(if
		(and
			(not (= oMover (gEgo mover:)))
			((gEgo looper:) isMemberOf: Grooper)
		)
		(= oMover ((gEgo looper:) oldMover:))
	)
	(if (and (!= xDest -1) oMover (<= (oMover x:) (gEgo x:)))
		(+= xDest 3160)
		(= oWhoToCue (oMover caller:))
		(gEgo posn: (+ (gEgo x:) 3160) (gEgo y:))
		(gEgo setMotion: PolyPath xDest yDest oWhoToCue)
	else
		(gEgo posn: (+ (gEgo x:) 3160) (gEgo y:))
		(if oMover
			(= oldX (oMover x:))
			(= oldY (oMover y:))
			(= oWhoToCue (oMover caller:))
			(gEgo setMotion: PolyPath oldX oldY oWhoToCue)
		)
	)
)

(class InfiniteScrollExit of ScrollExit
	(properties)

	(method (doVerb &tmp [temp0 2])
		(gEgo setMotion: PolyPath nOffX (gEgo y:))
		(= xDest -1)
	)
)

