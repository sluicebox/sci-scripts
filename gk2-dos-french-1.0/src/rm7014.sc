;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7014)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Actor)

(public
	rm7014 0
)

(instance rm7014 of ExitRoom
	(properties
		picture 7014
		east 7011 ; rm7011
		south 7011 ; rm7011
		west 7011 ; rm7011
	)

	(method (init)
		(super init: &rest)
		(cond
			((== gChapter 2)
				(lily loop: 2 x: 192 y: 92 init:)
			)
			((== gChapter 6)
				(lily loop: 1 x: 192 y: 100 init:)
			)
			((== gChapter 4)
				(if (not (IsFlag 400))
					(lily loop: 2 cel: 0 x: 192 y: 92 init:)
				else
					(lily init:)
				)
			)
		)
	)
)

(instance lily of View
	(properties
		x 193
		y 92
		view 37014
	)

	(method (doVerb)
		(cond
			((== gChapter 2)
				(gMessager say: 7 62 0 1 0 700) ; "(LOOK AT LILIES BEFORE THEY BLOOM)I wonder what kind of flowers these are?"
			)
			((== gChapter 4)
				(cond
					((not (IsFlag 400))
						(gMessager say: 7 62 0 1 0 700) ; "(LOOK AT LILIES BEFORE THEY BLOOM)I wonder what kind of flowers these are?"
					)
					((IsFlag 1044)
						(gMessager say: 4 62 0 1 0 700) ; "(LOOK AT LILIES AFTER PICKING ONE)It was nice of Father Getz to give me one of the lilies."
					)
					(else
						(PlayScene 428)
						(gEgo get: 45) ; invLily
						(gGame changeScore: 1044)
						(gCurRoom newRoom: 7011)
					)
				)
			)
			((== gChapter 6)
				(gMessager say: 5 62 0 1 0 700) ; "(RITTERSBERG TOWN SQUARE, LOOK AT LILIES CH 6, SAD)The lilies died after all."
			)
		)
	)
)

