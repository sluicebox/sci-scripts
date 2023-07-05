;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4014)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Feature)
(use Actor)

(public
	rm4014 0
)

(instance rm4014 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4014
		south 4004 ; rm4004
		west 4004 ; rm4004
	)

	(method (init)
		(vVendor init: setScript: FidgetScript)
		(fWeissWurst init:)
		(fHackfleisch init:)
		(fWurstInCase init:)
		(fOtherStuffRight init:)
		(fOtherStuffLeft init:)
		(super init: &rest)
		(gGame handsOn:)
	)
)

(instance vVendor of Prop
	(properties
		modNum 400
		x 370
		y 124
		view 25551
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (or (IsFlag 670) (== gChapter 3) (== gChapter 5))
					(gMessager say: 3 62 0 0 0 400) ; "(TRY TO TALK TO WURST LADY)I don't think she speaks much English. Besides, she only wants to talk about white sausages."
				else
					(SetFlag 670)
					(PlayScene 552)
				)
			)
			(17 ; invGabeWallet
				(cond
					((!= gChapter 5)
						(gMessager say: 20 14 0 0 0 400) ; "(TRY TO BUY MEAT CH 1 OR 3)I'm not much in the mood for meat at the moment."
					)
					((IsFlag 669)
						(gMessager say: 22 14 0 0 0 400) ; "(TRY TO BUY MEAT AFTER BUYING WURST)I've got plenty of meat already, thanks."
					)
					((not (IsFlag 690))
						(gMessager say: 21 14 0 0 0 400) ; "(TRY TO GIVE MONEY TO WURST LADY)I'd need to pick my poison first."
					)
					(else
						(SetFlag 669)
						(gEgo get: 49) ; invWurst
						(PlayScene 553 0 4004) ; rm4004
					)
				)
			)
			(else
				(gMessager say: 35 62 0 0 0 400) ; "(PICKUP, TRY TO SHOW ITEM TO WURST LADY)I don't think I want to show her THAT."
			)
		)
	)
)

(instance fHackfleisch of Feature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: 47 92 111 92 111 183 46 183)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 12 62 0 0 0 400) ; "(LOOK AT WURST BOOTH SIGN)"Hackfleish." That sounds yummy."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fWeissWurst of Feature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: 45 -2 110 -2 110 76 45 76)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(SetFlag 690)
				(gMessager say: 13 62 0 0 0 400) ; "Weiss Wurst. Six Marks."
			)
			(17 ; invGabeWallet
				(if (== gChapter 5)
					(if (IsFlag 669)
						(gMessager say: 15 14 0 0 0 400) ; "(TRY TO GET WURST--ALREADY GOT SOME)I already have some wurst."
					else
						(gGame handsOff:)
						(SetFlag 669)
						(gEgo get: 49) ; invWurst
						(PlayScene 553 0 4004) ; rm4004
					)
				else
					(gMessager say: 14 14 0 0 0 400) ; "(TRY TO GET WURST, CH 1 OR 3)I'm not much in the mood for white sausage at the moment."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fWurstInCase of Feature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: 287 215 462 210 465 334 291 334)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(SetFlag 690)
				(gMessager say: 16 62 0 0 0 400) ; "(LOOK AT WURST AT BOOTH, SARCASTIC)White sausage. Yum."
			)
			(17 ; invGabeWallet
				(fWeissWurst doVerb: 17)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fOtherStuffLeft of Feature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: 180 181 285 217 296 348 180 263)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 18 62 0 0 0 400) ; "(LOOKING AT WURST BOOTH)Blood sausage, head cheese, pork innards ... Mmmm Mmmm!"
			)
			(17 ; invGabeWallet
				(gMessager say: 19 14 0 0 0 400) ; "(TRY TO BUY SOMETHING GROSS AT WURST BOOTH)I really think I'll have to pass on that."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fOtherStuffRight of Feature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: 615 177 616 335 462 342 460 211)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(fOtherStuffLeft doVerb: theVerb)
	)
)

