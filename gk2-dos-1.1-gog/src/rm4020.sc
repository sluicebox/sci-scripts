;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4020)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Feature)
(use Actor)

(public
	rm4020 0
)

(instance rm4020 of ExitRoom ; "Cuckoo Clock Shop"
	(properties
		modNum 400
		noun 32
		picture 4020
		south 400 ; marienRm
	)

	(method (init)
		(super init: &rest)
		(if (and (== gChapter 3) (not (IsFlag 967)))
			(vCuckooClock init:)
		)
		(Lock 140 4020 1) ; WAVE
		(gGk2Music setLoop: -1 number: 4020 play:)
		(fOtherClocks init:)
		(pClockGuy init: setScript: FidgetScript)
		(gGame handsOn:)
	)

	(method (dispose)
		(Lock 140 4020 0) ; WAVE
		(gGk2Music fade: 0 20 10 1 self)
		(PlayScene 1239 0 400) ; marienRm
		(super dispose:)
	)
)

(instance pClockGuy of Prop
	(properties
		modNum 400
		x 238
		y 141
		view 51235
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(SetFlag 501)
				(gMessager say: 4 62 0 0 0 400) ; "(PICK UP, TRY TO TALK TO CLOCK VENDOR, WRY)He doesn't strike me as a sparklin' conversationalist."
			)
			(17 ; invGabeWallet
				(cond
					((and (not (IsFlag 967)) (not (IsFlag 502)))
						(gMessager say: 5 17 0 0 0 400) ; "(TRY TO GIVE MONEY TO CLOCK VENDOR)I'd rather pick somethin' out first."
					)
					((and (not (IsFlag 967)) (IsFlag 502))
						(gEgo get: 32) ; invCuckooClock
						((gUser hotCursor:) normalize:)
						(PlayScene 238 0 400) ; marienRm
					)
					(else
						(gMessager say: 6 38 0 0 0 400) ; "(TRY TO BUY SECOND CLOCK)One cuckoo clock is PLENTY."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vCuckooClock of View
	(properties
		modNum 400
		x 72
		y 289
		view 30235
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (not (IsFlag 503))
					(SetFlag 503)
					(SetFlag 502)
					(PlayScene 239)
				else
					(gMessager say: 7 62 0 0 0 400) ; "(LOOK AT WOODPECKER CLOCK ON COUNTER)Never know when you'll need another... oh, never mind."
				)
			)
			(17 ; invGabeWallet
				(cond
					((and (not (IsFlag 967)) (not (IsFlag 502)))
						(gMessager say: 5 17 0 0 0 400) ; "(TRY TO GIVE MONEY TO CLOCK VENDOR)I'd rather pick somethin' out first."
					)
					((and (not (IsFlag 967)) (IsFlag 502))
						(gEgo get: 32) ; invCuckooClock
						((gUser hotCursor:) normalize:)
						(PlayScene 238 0 400) ; marienRm
					)
					(else
						(gMessager say: 6 38 0 0 0 400) ; "(TRY TO BUY SECOND CLOCK)One cuckoo clock is PLENTY."
					)
				)
			)
		)
	)
)

(instance fOtherClocks of Feature
	(properties
		modNum 400
		nsRight 638
		nsBottom 216
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 967)
					(gMessager say: 9 62 0 0 0 400) ; "(TRY TO BUY SECOND CLOCK)One cuckoo clock is PLENTY."
				else
					(gMessager say: 8 62 0 0 0 400) ; "(A RARE MOMENT OF THOUGHTFULNESS)Authentic Black Forest Cuckoo Clocks. Maybe Gracie would like one for her shop redecoration."
				)
			)
			(17 ; invGabeWallet
				(gMessager say: 36 62 0 0 0 400) ; "(PICKUP, TRY TO BUY CLOCK OTHER THAN CUCKOO CLOCK IN CLOCK SHOP)Hmmm. I'm not crazy about that one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

