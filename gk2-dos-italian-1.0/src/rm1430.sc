;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1430)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Feature)

(public
	rm1430 0
)

(instance rm1430 of GK2Room
	(properties
		picture 1430
	)

	(method (init)
		(westExit init:)
		(eastExit init:)
		(southExit init:)
		(super init: &rest)
		(spot init:)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 1441
		BAD_SELECTOR 4
	)

	(method (setCursor param1)
		(param1 view: 998 loop: 1 cel: 0)
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		x 63536
		y 250
		BAD_SELECTOR 6
	)

	(method (doVerb)
		(PlayScene 1127 0 140) ; srGabeRoom
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 586
		nsTop 15
		nsRight 640
		nsBottom 334
		x 2000
		y 250
		BAD_SELECTOR 2
	)

	(method (doVerb)
		(PlayScene 1127 0 140) ; srGabeRoom
	)
)

(instance spot of GKFeature
	(properties
		nsLeft 267
		nsTop 87
		nsRight 421
		nsBottom 230
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((not (IsFlag 493))
						(SetFlag 493)
						(PlayScene 128)
					)
					((not (IsFlag 457))
						(gMessager say: 26 62 0 0 0 140) ; "(PICK UP, CH 2, LOOKING AT SECRET PASSAGEWAY TRIGGER BEFORE KNOWING WHAT IT DOES, CURIOUS)There's a hole in the mortar where a stone used to be."
					)
					(else
						(gMessager say: 27 62 0 0 0 140) ; "(PICK UP, CH 2, LOOKING AT SECRET PASSAGEWAY TRIGGER AFTER KNOWING WHAT IT DOES)That hole is a trigger for the secret passageway."
					)
				)
			)
			(65 ; invScrewdriver
				(if (IsFlag 479)
					(if (IsFlag 457)
						(ClearFlag 479)
						(PlayScene 130)
					else
						(gMessager say: 28 62 0 0 0 140) ; "(PICK UP, CH 2, USE SCREWDRIVER ON HOLE AGAIN BEFORE FINDING SECRET PASSAGEWAY)I should figure out what happened the FIRST time before I do it again."
					)
				else
					(SetFlag 479)
					(PlayScene 129 0 140) ; srGabeRoom
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

