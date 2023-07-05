;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7202)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm7202 0
)

(local
	local0
)

(instance rm7202 of ExitRoom
	(properties
		picture 7202
		south 720 ; dungeonRm
		west 720 ; dungeonRm
	)

	(method (init)
		(if (OneOf gChapter 2 4)
			(cot init:)
		)
		(super init: &rest)
		(if (== gChapter 6)
			(gabe init: setScript: FidgetScript)
		)
	)
)

(instance cot of GKFeature
	(properties
		x 454
		y 278
		BAD_SELECTOR 212
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 137 273 379 238 412 214 483 261 478 283 180 323
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance gabe of Prop
	(properties
		modNum 720
		x 167
		y 316
		view 20753
	)

	(method (init)
		(super init: &rest)
		(self setScript: FidgetScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 807)
						(gMessager say: 4 62 0 1 0 720) ; "(RITTERSBERG DUNGEON, TRY TO TALK TO GABRIEL AFTER FIRST TIME, SOFT)I don't want to disturb him."
					)
					((IsFlag 706)
						(SetFlag 807)
						(PlayScene 755)
					)
					(else
						(gGame changeScore: 1105)
						(SetFlag 706)
						(= local0 1)
						(gGk2Music fade: 0 5 5 1)
						(PlayScene 1754)
						(gGk2Music play: 0 0 fade: 63 5 5 0)
					)
				)
			)
			(96 ; invVonGlowerLetter
				(if (IsFlag 705)
					(gMessager say: 6 theVerb 0 1 0 720) ; "(TRY TO SHOW VON GLOWER'S LETTER TO GABRIEL AFTER READING IT, PROTECTIVE)I'll tell him about the letter... eventually. When I have everything else under control."
				else
					(gMessager say: 5 theVerb 0 1 0 720) ; "(TRY TO SHOW GABRIEL VON GLOWER'S LETTER, STUBBORN)I'd better see what the letter says myself first."
				)
			)
			(8 ; invTalisman
				(gMessager say: 7 theVerb 0 1 0 720) ; "(TRY TO GIVE TALISMAN TO GABRIEL IN DUNGEON, WORRIED)I'll keep the talisman until Gabriel's better. It might not react well to that stuff in his blood."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gabeFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gabe setCycle: End self)
			)
			(1
				(gabe setCycle: Beg self)
			)
			(2
				(self init:)
			)
		)
	)
)

