;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50600)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use foEExit)
(use Talker)
(use Sync)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roSlipperySlope 0
)

(local
	bTalking
	bYes
	bOnSlope
	nTargetX
	nTargetY
	nTargetY1
	nTargetY2
	nTargetX1
	nTargetX2
)

(class SlopedScaler of Scaler
	(properties
		frontX 190
		backX 0
		mn 0
		md 0
		m_sm 0
		sb 0
	)

	(method (init who fs fx fy bs bx by &tmp smn smd)
		(if argc
			(= client who)
			(= frontSize fs)
			(= frontX fx)
			(= frontY fy)
			(= backSize bs)
			(= backX bx)
			(= backY by)
		)
		(if (or (== fx bx) (== fy by) (== fs bs))
			(return 0)
		)
		(= frontSize (MulDiv frontSize 128 100))
		(= backSize (MulDiv backSize 128 100))
		(= smn (- backY frontY))
		(= smd (- backX frontX))
		(= sb (- frontY (MulDiv smn frontX smd)))
		(= slopeNum (- frontSize backSize))
		(= slopeDen (GetDistance fx fy bx by))
		(= mn (- smd))
		(for ((= md smn)) (or (> (Abs mn) 128) (> (Abs md) 128)) ((/= md 2))
			(/= mn 2)
		)
		(= m_sm (/ (+ (* mn mn) (* md md)) (* md mn)))
		(self doit:)
	)

	(method (doit &tmp scale oldScaleX oldScaleY b dist tx ty)
		(= oldScaleX (client scaleX:))
		(= oldScaleY (client scaleY:))
		(= b (- (client y:) (MulDiv (client x:) mn md)))
		(= tx (/ (- sb b) m_sm))
		(= ty (+ (MulDiv mn tx md) b))
		(= dist (GetDistance backX backY (client x:) (client y:)))
		(= scale (+ backSize (MulDiv dist slopeNum slopeDen)))
		(if (or (!= oldScaleX scale) (!= oldScaleY scale))
			(client scaleX: scale scaleY: scale)
		)
	)
)

(instance foPlanterExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 265 53 276 97 315 -1 315
					yourself:
				)
		)
	)

	(method (doVerb)
		(gEgo setScript: soExit)
	)
)

(instance soExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 30 300 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -40 350 self)
			)
			(2
				(gCurRoom newRoom: 50400) ; roInPlanter
			)
		)
	)
)

(instance soComeIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: -40 350 doit: setMotion: MoveTo 30 300 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foTenebrousLSExit of ExitFeature ; UNUSED
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
		(self setRect: 615 0 632 316)
	)

	(method (doVerb)
		(gEgo setMotion: PolyPath 632 300 self)
	)

	(method (cue)
		(gCurRoom newRoom: 50700) ; roTenebrousLS
	)
)

(instance foTree of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 55 60 32 79 37 112 28 123 69 132 154 174 195 125 206 75 181 46 189
					yourself:
				)
		)
		(self addHotspotVerb: 1 52)
		(= x 92)
		(= y 180)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				((ScriptID 64017 0) set: 195) ; oFlags
				(gEgo setScript: soTreeTalk)
			)
			(52 ; ioDawburr
				(if ((ScriptID 64017 0) test: 199) ; oFlags
					(gEgo setScript: soTreeTalkDawburr)
				else
					(gEgo setScript: soCheckTreeSap)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poTree of Prop
	(properties
		x 110
		y 127
		priority 10
		fixPriority 1
		view 50601
		loop 1
		cycleSpeed 10
	)
)

(instance voTreeNormalMouth of View
	(properties
		x 110
		y 127
		priority 20
		fixPriority 1
		view 50601
		loop 3
	)
)

(instance poSap of Prop
	(properties
		x 103
		y 96
		priority 25
		fixPriority 1
		view 50601
		loop 6
		cycleSpeed 10
	)
)

(instance toTree of Talker
	(properties
		x 110
		y 127
		view 50601
		loop 3
		priority 20
	)

	(method (init)
		(MouthSync oSpecialSync: coHandleTree)
		(MouthSync nSpecialSelector: 178)
		(voTreeNormalMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(MouthSync oSpecialSync: 0)
		(MouthSync nSpecialSelector: 0)
		(voTreeNormalMouth show:)
		(poTree loop: 2 cel: 0 doit: setCycle: 0)
		(super dispose: &rest)
	)
)

(instance coHandleTree of CueMe
	(properties)

	(method (cue nWhich)
		(switch nWhich
			(0
				(if (toTree mouth:)
					((toTree mouth:) show:)
				else
					(voTreeNormalMouth show:)
				)
				(poTree loop: 2 cel: 0 doit: setCycle: 0)
			)
			(8
				(if (toTree mouth:)
					((toTree mouth:) hide:)
				else
					(voTreeNormalMouth hide:)
				)
				(poTree loop: 4 doit: setCycle: Fwd)
			)
			(9
				(if (toTree mouth:)
					((toTree mouth:) hide:)
				else
					(voTreeNormalMouth hide:)
				)
				(poTree loop: 5 doit: setCycle: Fwd)
				(if (not ((ScriptID 64017 0) test: 199)) ; oFlags
					((ScriptID 64017 0) set: 199) ; oFlags
					(poSap init: setCycle: End)
				)
			)
		)
	)
)

(instance soTreeTalk of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 177 204 self)
			)
			(1
				(gGame handsOff:)
				(poTree setScript: 0)
				(goMusic1 setMusic: 50699)
				(gEgo setHeading: 315 self)
			)
			(2
				(switch gnTreeTalk
					(0
						(self setScript: soTreeTalk1 self)
						(++ gnTreeTalk)
					)
					(1
						(self setScript: soTreeTalk2 self)
						(++ gnTreeTalk)
					)
					(2
						(self setScript: soTreeTalk3 self)
						(++ gnTreeTalk)
					)
					(3
						(self setScript: soTreeTalk4 self)
						(++ gnTreeTalk)
					)
					(4
						(self setScript: soTreeTalk5 self)
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTreeTalk1 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 64007 1) 0 self) ; soEgoGetLow
			)
			(1
				(gMessager say: 1 1 5 1 self) ; "This tree's trunk is covered with some very sticky stuff."
			)
			(2
				(poTree cycleSpeed: 10 setCycle: End self)
			)
			(3
				(poTree loop: 2 doit:)
				(voTreeNormalMouth init:)
				(= gtTree toTree)
				(gMessager sayRange: 1 1 5 2 4 self) ; "Hey! Stop poking me!"
			)
			(4
				(= gtTree 0)
				(voTreeNormalMouth dispose:)
				(poTree loop: 1 cel: 13 doit:)
				(poTree setScript: soFallAsleepTimer)
				(self dispose:)
			)
		)
	)
)

(instance soTreeTalk2 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 1 6 1 self) ; "You sound discouraged."
			)
			(1
				(if (== (poTree loop:) 4)
					(poTree setCycle: 0 loop: 1 cel: 13 doit:)
					(self cue:)
				else
					(poTree cycleSpeed: 10 setCycle: End self)
				)
			)
			(2
				(poTree loop: 2 doit:)
				(voTreeNormalMouth init:)
				(= gtTree toTree)
				(gMessager sayRange: 1 1 6 2 6 self) ; "Not so much discouraged, but sometimes I do get a little sentimental."
			)
			(3
				(= gtTree 0)
				(voTreeNormalMouth dispose:)
				(poTree loop: 1 cel: 13 doit:)
				(poTree setScript: soFallAsleepTimer)
				(self dispose:)
			)
		)
	)
)

(instance soTreeTalk3 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 1 7 1 self) ; "I'm searching for my parents. I think they were captured by Lycentia, a sorceress I was told came from around here. Could you help me? Have you heard of her?"
				(= ticks 60)
			)
			(1
				(if (== (poTree loop:) 4)
					(poTree setCycle: 0 loop: 1 cel: 13 doit:)
					(self cue:)
				else
					(poTree cycleSpeed: 10 setCycle: End self)
				)
			)
			(2)
			(3
				(poTree loop: 2 doit:)
				(voTreeNormalMouth init:)
				(= gtTree toTree)
				(gMessager say: 1 1 7 2 self) ; "You lost your parents? (GETTING TEARY) Oh, me too. I was transplanted at birth! (SNIFFING) You know, my dad was cut down in his prime of life...by a guy chasing a wolf. (MORE) And Mom? She fell in the forest and nobody heard it! (CRYING NOW) Bwah-ha-hah..."
			)
			(4
				(if (not ((ScriptID 64017 0) test: 199)) ; oFlags
					((ScriptID 64017 0) set: 199) ; oFlags
					(poSap cel: (poSap lastCel:) init:)
				)
				(= gtTree 0)
				(voTreeNormalMouth dispose:)
				(poTree loop: 4 cel: 0 doit: setCycle: Fwd)
				(poTree setScript: soFallAsleepTimer)
				(self dispose:)
			)
		)
	)
)

(instance soTreeTalk4 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 1 8 1 self) ; "Gee, I'm sorry."
			)
			(1
				(if (== (poTree loop:) 4)
					(poTree setCycle: 0 loop: 1 cel: 13 doit:)
					(self cue:)
				else
					(poTree cycleSpeed: 10 setCycle: End self)
				)
			)
			(2
				(poTree loop: 2 doit:)
				(voTreeNormalMouth init:)
				(= gtTree toTree)
				(gMessager say: 1 1 8 2 self) ; "(RECOVERING) Oh, that's all right. I told you: I'm just a little sentimental SAP! Look at me. I'm a mess."
			)
			(3
				(= gtTree 0)
				(voTreeNormalMouth dispose:)
				(poTree loop: 4 cel: 0 doit: setCycle: Fwd)
				(gMessager say: 1 1 8 3 self) ; "Well, you are rather drippy."
			)
			(4
				(poTree setScript: soFallAsleepTimer)
				(self dispose:)
			)
		)
	)
)

(instance soTreeTalk5 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 1 9 1 self) ; "I hope you're feeling better."
			)
			(1
				(if (== (poTree loop:) 4)
					(poTree setCycle: 0 loop: 1 cel: 13 doit:)
					(self cue:)
				else
					(poTree cycleSpeed: 10 setCycle: End self)
				)
			)
			(2
				(poTree loop: 2 doit:)
				(voTreeNormalMouth init:)
				(= gtTree toTree)
				(gMessager say: 1 1 9 2 self) ; "Yes, I am. But just don't get me started again, okay? Good luck finding your...(SOB) your...(SOB) Bwah-ha-hawh! (DEGENERATES INTO TEARS AGAIN)"
			)
			(3
				(= gtTree 0)
				(voTreeNormalMouth dispose:)
				(poTree loop: 4 cel: 0 doit: setCycle: Fwd)
				(poTree setScript: soFallAsleepTimer)
				(self dispose:)
			)
		)
	)
)

(instance soTreeTalkDawburr of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 177 204 self)
			)
			(1
				(gGame handsOff:)
				(poTree setScript: 0)
				(goMusic1 setMusic: 50699)
				(gEgo setHeading: 315 self)
			)
			(2
				(gMessager say: 1 52 0 1 self) ; "Excuse me. Do you mind if I borrow a little of this sap?"
			)
			(3
				(if (== (poTree loop:) 4)
					(poTree setCycle: 0 loop: 1 cel: 13 doit:)
					(self cue:)
				else
					(poTree cycleSpeed: 10 setCycle: End self)
				)
			)
			(4
				(poTree loop: 2 doit:)
				(voTreeNormalMouth init:)
				(= gtTree toTree)
				(gMessager say: 1 52 0 2 self) ; "No, not at all. Go ahead. Use me. Everyone does. I just hope that SOME how, SOME day, SOMEone SOMEwhere will find SOME way to make SOMEthing out of us trees. (SOB) And then, they can cut us all down. (ALL OUT BLUBBERING) Oh, what if somebody invents telephone poles? Bwah-ha-hawh!"
			)
			(5
				(= gtTree 0)
				(voTreeNormalMouth dispose:)
				(poTree loop: 4 cel: 0 doit: setCycle: Fwd)
				(poTree setScript: soFallAsleepTimer)
				(self setScript: soGetSappyDawburr self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soFallAsleepTimer of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(poTree loop: 1 cel: 13 setCycle: 0 doit:)
				(= seconds 5)
			)
			(2
				(goMusic1 fadeOut: 6 20)
				(= ticks 140)
				(poTree cycleSpeed: 10 setCycle: CT 9 -1)
			)
			(3
				(goMusic1 fadeIn: 50400)
			)
		)
	)
)

(instance soCheckTreeSap of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo face: foTree self)
			)
			(1
				(gMessager say: 1 52 10 0 self) ; "There's a little sap on this tree, but not enough...yet."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGetSappyDawburr of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 94 227 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(3
				(gEgo put: ((ScriptID 64001 0) get: 61)) ; oInvHandler, ioDawburr
				(gEgo get: ((ScriptID 64001 0) get: 62)) ; oInvHandler, ioSappyDawburr
				((ScriptID 64017 0) set: 178) ; oFlags
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance poTorin of Prop
	(properties
		view 50602
	)

	(method (init)
		(super init: &rest)
		(self setScale: 0)
	)
)

(instance aoTorinSlips of Actor
	(properties
		scaleSignal 4
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance aoTorin of Actor
	(properties
		view 50602
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setStep: 5 4)
		(self setCycle: Walk)
		(self setScaler: SlopedScaler 100 374 265 55 530 172)
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance oGrass of TPSound
	(properties)
)

(class YesFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self myPriority: 100)
	)

	(method (handleEvent event &tmp temp0 [temp1 2])
		(if
			(and
				((ScriptID 64017 0) test: 160) ; oFlags
				(self onMe: event)
				(not bYes)
			)
			(oGrass stop:)
			(= bTalking 1)
			(= bYes 1)
			(= temp0 (Random 1 9))
			(oGrass playMessage: 0 0 2 temp0 oStopTalking 50600 1)
		)
		(super handleEvent: event &rest)
	)
)

(instance foSlope of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 138 37 148 156 214 162 277 201 301 234 258 312 629 312 629 82 544 95 520 106 481 94 436 47 356 4 322 24 225 29
					yourself:
				)
		)
		(self myPriority: 0)
		(self addHotspotVerb: 1)
	)

	(method (handleEvent event &tmp temp0 [temp1 2])
		(if
			(and
				((ScriptID 64017 0) test: 160) ; oFlags
				((ScriptID 64017 0) test: 198) ; oFlags
				(self onMe: event)
				(gUser canControl:)
				(or (not bTalking) bYes)
			)
			(= bTalking 1)
			(= bYes 0)
			(oGrass stop:)
			(= temp0 (Random 1 17))
			(oGrass playMessage: 0 0 3 temp0 oStopTalking 50600 1)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(cond
					(bOnSlope
						(gCurRoom setScript: soSlipAndFall)
					)
					(
						(and
							((ScriptID 64017 0) test: 160) ; oFlags
							(not ((ScriptID 64017 0) test: 198)) ; oFlags
						)
						(gEgo setScript: soGrassYes)
					)
					(
						(and
							(not ((ScriptID 64017 0) test: 160)) ; oFlags
							(not ((ScriptID 64017 0) test: 197)) ; oFlags
						)
						(gEgo setScript: soGrassNo)
					)
					(else
						(gCurRoom setScript: soGetOnSlopeAndSlip)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soGrassYes of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 229 221 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gMessager say: 2 1 0 0 self) ; "Now that I've rescued your friends, will you help me cross?"
			)
			(3
				(gMessager say: 0 0 2 7 self) ; "okay"
			)
			(4
				((ScriptID 64017 0) set: 198) ; oFlags
				(foPath1 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGrassNo of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 229 221 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gMessager say: 2 1 4 0 self) ; "Say, grass...would you tell me where it's safe to step?"
			)
			(3
				(gMessager say: 0 0 3 14 self) ; "no way"
			)
			(4
				((ScriptID 64017 0) set: 197) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oStopTalking of CueMe
	(properties)

	(method (cue)
		(gGame setScript: soPauseABit)
	)
)

(instance soPauseABit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 5)
			)
			(1
				(= bTalking 0)
				(= bYes 0)
				(self dispose:)
			)
		)
	)
)

(instance foPath1 of YesFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 350 240 400 290)
	)

	(method (doVerb)
		(gCurRoom setScript: soGetOnSlopeAndStay)
	)
)

(instance foPath2 of YesFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 365 160 415 210)
	)

	(method (doVerb)
		(gCurRoom setScript: soScuttleToPos2)
	)
)

(instance foPath3 of YesFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 415 200 465 250)
	)

	(method (doVerb)
		(gCurRoom setScript: soScuttleToPos3)
	)
)

(instance foPath4 of YesFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 465 225 515 275)
	)

	(method (doVerb)
		(gCurRoom setScript: soScuttleToPos4)
	)
)

(instance foPath5 of YesFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 480 180 530 230)
	)

	(method (doVerb)
		(gCurRoom setScript: soScuttleToPos5)
	)
)

(instance foPath6 of YesFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 505 150 555 200)
	)

	(method (doVerb)
		(gCurRoom setScript: soScuttleToPos6)
	)
)

(instance soGetOnSlope of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 229 221 self)
			)
			(1
				(goMusic1 setMusic: 50698)
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poTorin loop: 0 cel: 0 posn: 229 221 init: setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soSlipAndFall of TPScript
	(properties)

	(method (changeState newState &tmp nDistX nDistY)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 50604)
				(aoTorinSlips
					view: 50602
					posn: (aoTorin x:) (aoTorin y:)
					loop: 2
					cel: 0
					init:
					moveSpeed: 1
					setStep: 5 8
					setScaleDirect: (aoTorin scaleY:)
					setCycle: End self
				)
				(aoTorin dispose:)
				(= nDistX
					(/
						(= nDistY
							(-
								(= nTargetY
									(Max
										(aoTorinSlips y:)
										(-
											315
											(MulDiv 45 (aoTorin scaleY:) 128)
										)
									)
								)
								(aoTorinSlips y:)
							)
						)
						2
					)
				)
				(= nTargetX (+ (aoTorinSlips x:) nDistX))
				(= nTargetY1 (+ (aoTorinSlips y:) (/ nDistY 3)))
				(= nTargetY2 (+ (aoTorinSlips y:) (/ (* nDistY 2) 3)))
				(= nTargetX1 (+ (aoTorinSlips x:) (/ nDistX 3)))
				(= nTargetX2 (+ (aoTorinSlips x:) (/ (* nDistX 2) 3)))
				(aoTorinSlips setMotion: MoveTo nTargetX1 nTargetY1)
			)
			(1
				(if (not ((ScriptID 64017 0) test: 160)) ; oFlags
					(gMessager say: 0 0 4 1 self) ; "(SLIPS) Whoa! This is really slippery!"
				else
					(self cue:)
				)
			)
			(2
				(aoTorinSlips
					loop: 3
					cel: 0
					setMotion: MoveTo nTargetX2 nTargetY2
					setCycle: End self
				)
			)
			(3
				(aoTorinSlips
					loop: 4
					cel: 0
					setMotion: MoveTo nTargetX nTargetY
					setCycle: End self
				)
			)
			(4
				(aoTorinSlips
					loop: 5
					cel: 0
					setMotion: MoveTo nTargetX nTargetY
					setCycle: End self
				)
				(goSound1 playSound: 50604 self)
			)
			(5)
			(6
				(aoTorinSlips dispose:)
				(= bOnSlope 0)
				(foPath2 dispose:)
				(foPath3 dispose:)
				(foPath4 dispose:)
				(foPath5 dispose:)
				(foPath6 dispose:)
				(if ((ScriptID 64017 0) test: 198) ; oFlags
					(foPath1 init:)
				)
				(foTree init:)
				(if (not ((ScriptID 64017 0) test: 160)) ; oFlags
					((ScriptID 64019 0) show: 0 42 4) ; DeathDialog
				else
					((ScriptID 64019 0) show: 0 42 11) ; DeathDialog
				)
				(goMusic1 setMusic: 50400)
				(gEgo posn: 190 229 setLoop: 6 show:)
				(= cycles 2)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGetOnSlopeAndSlip of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soGetOnSlope self)
			)
			(1
				(poTorin dispose:)
				(aoTorin posn: 374 265 init: hide:)
				(self setScript: soSlipAndFall self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soGetOnSlopeAndStay of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soGetOnSlope self)
			)
			(1
				(gGame handsOff:)
				(poTorin dispose:)
				(aoTorin posn: 374 265 init: setMotion: MoveTo 375 265 self)
			)
			(2
				(foTree dispose:)
				(foPath1 dispose:)
				(foPath2 init:)
				(= bOnSlope 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soScuttleToPos2 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoTorin setMotion: MoveTo 390 185 self)
			)
			(1
				(foPath2 dispose:)
				(foPath3 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soScuttleToPos3 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoTorin setMotion: MoveTo 440 225 self)
			)
			(1
				(foPath3 dispose:)
				(foPath4 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soScuttleToPos4 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoTorin setMotion: MoveTo 490 250 self)
			)
			(1
				(foPath4 dispose:)
				(foPath5 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soScuttleToPos5 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoTorin setMotion: MoveTo 505 205 self)
			)
			(1
				(foPath5 dispose:)
				(foPath6 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soScuttleToPos6 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoTorin setMotion: MoveTo 530 172 self)
			)
			(1
				(aoTorin dispose:)
				(poTorin loop: 6 cel: 0 posn: 530 172 init: setCycle: End self)
			)
			(2
				((ScriptID 64017 0) set: 196) ; oFlags
				(gCurRoom newRoom: 50700) ; roTenebrousLS
				(self dispose:)
			)
		)
	)
)

(instance roSlipperySlope of TPRoom
	(properties
		picture 50600
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 50400)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 2 261 2 310 28 313 92 301 124 285 149 278 172 271 230 237 280 220 193 171 162 175 170 201 118 210 71 203 2 219
					yourself:
				)
		)
		(foPlanterExit init:)
		(foSlope init:)
		(foTree init:)
		(if ((ScriptID 64017 0) test: 199) ; oFlags
			(poSap cel: (poSap lastCel:) init:)
		)
		(if (and ((ScriptID 64017 0) test: 160) ((ScriptID 64017 0) test: 198)) ; oFlags, oFlags
			(foPath1 init:)
		)
		(if gnTreeTalk
			(poTree cel: 9)
		else
			(poTree cel: 0)
		)
		(poTree init:)
		(gEgo init: normalize:)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(else
				(gEgo setScript: soComeIn)
			)
		)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 160) ; oFlags
		(gEgo get: ((ScriptID 64001 0) get: 61)) ; oInvHandler, ioDawburr
	)
)

