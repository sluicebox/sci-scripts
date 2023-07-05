;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7030)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Feature)
(use Actor)

(public
	rm7030 0
)

(local
	local0
)

(instance rm7030 of ExitRoom
	(properties
		picture 7030
		east 700 ; sqRm
		south 700 ; sqRm
		west 700 ; sqRm
	)

	(method (init)
		(postBuzzer init:)
		(postWindow init:)
		(if (IsFlag 720)
			(closedSign init:)
		)
		(super init: &rest)
	)

	(method (newRoom)
		(cond
			((not (gCast contains: frauGelder)))
			((and (== gChapter 4) (gCast contains: letter3))
				(gEgo get: 43) ; invGraceEnvelope3
				(PlayScene 432)
			)
			((and (!= gChapter 6) (not (gCast contains: package)))
				(PlayScene 164)
			)
			((== gChapter 2)
				(gEgo get: 80) ; invAddressedPackage
				(PlayScene 165)
			)
		)
		(super newRoom: &rest)
	)
)

(instance postBuzzer of GKFeature
	(properties
		noun 6
		modNum 700
		nsLeft 528
		nsTop 196
		nsRight 558
		nsBottom 240
		sightAngle 40
		approachX 540
		approachY 252
		x 542
		y 218
	)

	(method (onMe)
		(return (and (not local0) (super onMe: &rest)))
	)

	(method (doVerb theVerb)
		(if (and (not (gCast contains: frauGelder)) (== theVerb 62)) ; Do
			(switch gChapter
				(2
					(PlayScene 169)
					(frauGelder init:)
					(self dispose:)
				)
				(4
					(cond
						((not (IsFlag 614))
							(SetFlag 614)
							(PlayScene 429)
							(gEgo get: 37) ; invGabeLetter2
							(frauGelder init:)
							(self dispose:)
						)
						((and (IsFlag 618) (not (gEgo has: 44))) ; invDiaryTranslation
							(PlayScene 430)
							(gEgo get: 44) ; invDiaryTranslation
						)
						(else
							(PlayScene 431)
							(frauGelder init:)
						)
					)
				)
				(6
					(if (not (IsFlag 720))
						(SetFlag 720)
						(gEgo get: 57) ; invVonGlowerLetter
						(PlayScene 761 0 700) ; sqRm
					else
						(= noun 6)
						(super doVerb: theVerb)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance postWindow of GKFeature
	(properties
		noun 9
		nsLeft 404
		nsTop 60
		nsRight 526
		nsBottom 273
	)

	(method (onMe)
		(if (or local0 (== gChapter 6))
			(return 0)
		else
			(super onMe: &rest)
		)
	)
)

(instance grace of Prop
	(properties
		sightAngle 360
		x 242
		y 119
		view 20703
	)

	(method (doVerb))
)

(instance frauGelder of Prop
	(properties
		noun 3
		x 487
		y 147
		view 21161
	)

	(method (init)
		(super init: &rest)
		(self setScript: (FidgetScript new:))
		(= local0 1)
		(grace init: setScript: FidgetScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; invGraceWallet
				(cond
					((== gChapter 2)
						(if (gCast contains: package)
							(= local0 0)
							(self dispose:)
							(PlayScene 168 0 12) ; endChapter
						else
							(gMessager say: 2 theVerb 0 1) ; "(TRY TO GIVE FRAU GELDER MONEY BEFORE TRYING TO MAIL SOMETHING)She hasn't asked me for money."
						)
					)
					((gCast contains: letter3)
						(PlayScene 434)
						(letter3 dispose:)
						(SetFlag 619)
					)
					(else
						(gMessager say: 2 theVerb 0 1) ; "(TRY TO GIVE FRAU GELDER MONEY BEFORE TRYING TO MAIL SOMETHING)She hasn't asked me for money."
					)
				)
			)
			(44 ; invAddressedPackage
				(if (IsFlag 494)
					(PlayScene 167)
				else
					(SetFlag 494)
					(PlayScene 166)
				)
				(package init:)
				(gEgo put: 80) ; invAddressedPackage
				(gCurInvView update:)
				(gUser BAD_SELECTOR: 62)
				((gUser BAD_SELECTOR:) update:)
			)
			(9 ; invGracePackage1
				(gMessager say: 1 9 0 1) ; "(TRY TO GIVE UNADDRESSED PACKAGE TO POST OFFICE LADY)I have to get an address first."
			)
			(83 ; invGraceEnvelope3
				(PlayScene 433)
				(gEgo put: 43) ; invGraceEnvelope3
				(gCurInvView update:)
				(gUser BAD_SELECTOR: 62)
				((gUser BAD_SELECTOR:) update:)
				(letter3 init:)
			)
			(62 ; Do
				(super doVerb: theVerb)
			)
			(else
				(gMessager say: 12 62 0 1 0 700) ; "(TRY TO MAIL ITEM OTHER THAN LETTER OR PACKAGE)I don't want to mail that!"
			)
		)
	)
)

(instance package of View
	(properties
		x 383
		y 290
		priority 119
		fixPriority 1
		view 30166
		signal 2049
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 700) ; sqRm
			)
			(10 ; invGraceWallet
				(frauGelder doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance letter3 of View
	(properties
		x 390
		y 290
		priority 119
		fixPriority 1
		view 30166
		loop 1
		cel 1
		signal 2049
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 700) ; sqRm
			)
			(10 ; invGraceWallet
				(frauGelder doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance closedSign of View
	(properties
		noun 6
		x 450
		y 160
		view 131
	)
)

