;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1313)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use System)

(public
	rm1313 0
)

(instance rm1313 of ExitRoom
	(properties
		picture 1319
		south 130 ; srLibRoom
	)

	(method (init)
		(Load rsVIEW 124)
		(twriter init:)
		(super init: &rest)
		(phone init:)
		(manuscript init:)
		(if (not (IsFlag 484))
			(voodooBook init:)
		)
		(= scratch 1)
		(PlayScene 2158)
	)

	(method (dispose)
		(if scratch
			(PlayScene 3158 0 -1)
		)
		(super dispose:)
	)
)

(instance sSendPackage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(PlayScene 158 self)
			)
			(1
				(gCurRoom scratch: 0)
				(PlayScene 1158 0 130) ; srLibRoom
			)
		)
	)
)

(instance phone of GKFeature
	(properties
		modNum 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 531 108 553 174 530 251 620 274 622 112
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== gChapter 6) (not (OneOf theVerb 96 73 6))) ; invVonGlowerLetter, invVonGlowerCard, invBarclayCard
			(gMessager say: 17 62 0 1 0 130) ; "(CH 6, WORRIEDLY)I don't have time for that today."
			(return 1)
		)
		(return
			(switch theVerb
				(62 ; Do
					(gMessager say: 8 62 0 1 0 130) ; "(LOOK AT PHONE)Who should I call?"
				)
				(6 ; invBarclayCard
					(gUser sel_712: 62)
					((gUser sel_715:) update:)
					(cond
						((and (IsFlag 466) (not (IsFlag 465)))
							(SetFlag 465)
							(PlayScene 160)
						)
						((and (IsFlag 616) (not (IsFlag 604)))
							(SetFlag 604)
							(PlayScene 421)
							(gEgo get: 41) ; invDallmeierNote
							(gGame changeScore: 1037)
						)
						((and (IsFlag 465) (not (IsFlag 616)))
							(gMessager say: 3 theVerb 0 1 0 130) ; "(CONFIDENT)Professor Barclay will call when he finds out something."
						)
						((IsFlag 465)
							(gMessager say: 4 theVerb 0 1 0 130) ; "I don't want to bother Professor Barclay again."
						)
						(else
							(gMessager say: 9 theVerb 0 1 0 130) ; "I don't need to call Professor Barclay right now."
						)
					)
				)
				(81 ; invDallmeierNote
					(gUser sel_712: 62)
					((gUser sel_715:) update:)
					(cond
						((not (IsFlag 640))
							(SetFlag 640)
							(PlayScene 422)
							(gGame changeScore: 1038)
							(SetFlag 626)
							(SetFlag 17)
						)
						((IsFlag 626)
							(gMessager say: 5 theVerb 0 1 0 130) ; "(TRY TO CALL DALLMEIER AGAIN)I already have an appointment with Herr Dallmeier."
						)
						((proc11_15 8414)
							(PlayScene 423)
							(SetFlag 626)
						)
						(else
							(gMessager say: 10 theVerb 0 1 0 130) ; "I don't have any thing to talk to Herr Dallmeier about at the moment."
						)
					)
				)
				(80 ; invLudwigBio
					(cond
						((not (IsFlag 281))
							(gMessager say: 12 theVerb 0 1 0 130) ; "(HESITANT)I'm not sure why I'd want to call the biography's publisher."
						)
						((not (gEgo has: 42)) ; invChaphillNote
							(PlayScene 424)
							(gEgo get: 42) ; invChaphillNote
							(gGame changeScore: 1042)
						)
						(else
							(gMessager say: 13 theVerb 0 1 0 130) ; "There's no reason to call the publisher again."
						)
					)
				)
				(82 ; invChaphillNote
					(gUser sel_712: 62)
					((gUser sel_715:) update:)
					(cond
						((gEgo has: 44) ; invDiaryTranslation
							(gMessager say: 15 theVerb 0 1 0 130) ; "(TRY TO CALL CHAPHILL AGAIN)I don't think Mr. Chaphill wants to hear from me again."
						)
						((IsFlag 613)
							(gMessager say: 14 theVerb 0 1 0 130) ; "(FRUSTRATED)I don't think pleading with Mr. Chaphill will help."
						)
						(else
							(SetFlag 613)
							(PlayScene 425)
							(gGame changeScore: 1043)
						)
					)
				)
				(96 ; invVonGlowerLetter
					(gMessager say: 28 96 0 1 0 130) ; "(PICKUP, TRY TO CALL OR WRITE VON GLOWER CH 6, UPSET)What could I possibly SAY to von Glower that would make any difference now?"
				)
				(73 ; invVonGlowerCard
					(gMessager say: 28 96 0 1 0 130) ; "(PICKUP, TRY TO CALL OR WRITE VON GLOWER CH 6, UPSET)What could I possibly SAY to von Glower that would make any difference now?"
				)
				(63 ; invGabeLetter1
					(gMessager say: 25 62 0 1 0 130) ; "(CLICK ANY OF GABE'S LETTERS TO GRACE ON PHONE - CH2-4)I don't have a phone number for Gabriel. I don't even know where he's staying."
				)
				(64 ; invGabeLetter2
					(gMessager say: 25 62 0 1 0 130) ; "(CLICK ANY OF GABE'S LETTERS TO GRACE ON PHONE - CH2-4)I don't have a phone number for Gabriel. I don't even know where he's staying."
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance twriter of GKFeature
	(properties
		modNum 130
		nsBottom 201
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 218 145 224 286 374 283 369 141 459 132 455 75 190 87 190 108 162 111 145 190 180 143
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 96 73) ; invVonGlowerLetter, invVonGlowerCard
				(gMessager say: 28 96 0 1 0 130) ; "(PICKUP, TRY TO CALL OR WRITE VON GLOWER CH 6, UPSET)What could I possibly SAY to von Glower that would make any difference now?"
			)
			((!= theVerb 62) ; Do
				(super doVerb: theVerb)
			)
			((and (== gChapter 2) (IsFlag 491))
				(gMessager say: 22 theVerb 0 1 0 130)
			)
			(
				(and
					(== theVerb 62) ; Do
					(IsFlag 179)
					(IsFlag 150)
					(IsFlag 465)
					(gEgo has: 25) ; invChristianJournal
					(gEgo has: 24) ; invVictorJournal
				)
				(gEgo put: 25) ; invChristianJournal
				(gEgo put: 24) ; invVictorJournal
				(gEgo put: 23) ; invWerewolfBook
				(SetFlag 491)
				(gCurRoom setScript: sSendPackage)
			)
			((and (== gChapter 4) (IsFlag 302))
				(if (IsFlag 634)
					(gMessager say: 22 theVerb 0 0 0 130)
				else
					(gCurRoom setScript: typeCh4)
				)
			)
			((== gChapter 4)
				(gMessager say: 1 theVerb 0 1 0 130)
			)
			((== gChapter 6)
				(gMessager say: 17 theVerb 0 1 0 130)
			)
			(else
				(gMessager say: 21 theVerb 0 1 0 130)
			)
		)
	)
)

(instance manuscript of GKFeature
	(properties
		modNum 130
		BAD_SELECTOR 159
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 178 34 168 112 224 31 285 -1 297
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((== gChapter 6)
						(gMessager say: 18 theVerb 0 1 0 130) ; "(CH 6, LOOK AT MANUSCRIPT, SAD AT FIRST, THEN WRY)I wonder if Gabriel will ever write again? (SIGH) We can only hope not."
					)
					((IsFlag 483)
						(gMessager say: 23 theVerb 0 1 0 130) ; "(TRY TO LOOK AT GABE'S MANUSCRIPT 2CD TIME, SARCASTIC)It wasn't worth picking up the FIRST time."
					)
					(else
						(super doVerb: theVerb)
						(SetFlag 483)
					)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance voodooBook of GKFeature
	(properties
		noun 7
		modNum 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 415 198 394 265 450 282 468 209
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(super doVerb: theVerb)
				(SetFlag 484)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance typeCh4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 62 0 1 self 130) ; "(THOUGHTFUL)I should get a letter off to Gabriel. I need to include a note to Ubergrau about the research permit."
			)
			(1
				(SetFlag 634)
				(gEgo get: 43) ; invGraceEnvelope3
				(gCurRoom scratch: 0)
				(PlayScene 420 0 130) ; srLibRoom
			)
		)
	)
)

