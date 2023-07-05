;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20900)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roVedarCu 0
)

(instance foExit of Feature
	(properties
		nsLeft 550
		nsTop 218
		nsRight 624
		nsBottom 312
		approachX 626
		approachY 280
		x 628
		y 282
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
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
				(gEgo approachThenFace: foExit self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 668 300 self)
			)
			(2
				(gCurRoom newRoom: 20100) ; roCliffScroller
			)
		)
	)
)

(instance poMan of Prop
	(properties
		noun 1
		approachX 416
		approachY 226
		x 334
		y 184
		view 20103
		loop 1
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 53) ; oFlags
			(= loop 4)
			(= cel (self lastCel:))
			(= gtVeder toVederPillow)
		else
			(= loop 1)
			(= cel 0)
			(= gtVeder toVeder)
		)
		(super init: &rest)
		(self approachVerbs: 2) ; ioAx
		(if ((ScriptID 64017 0) test: 53) ; oFlags
			(self
				addHotspotVerb: 33 1 36 40 37 34 31 27 32 24 30 29 25 48 28 26
			)
		else
			(self addHotspotVerb: 1)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 27 32 24 30 31 29 25 48 28 26) ; ioSmallDoorTile, ioFloorTile, ioGuillotineTile, ioTubTile, ioSeatTile, ioWarningTile, ioStepTile, ioCleanTile, ioTableTopTile, ioTrivetTile
			(if ((ScriptID 64017 0) test: 53) ; oFlags
				(gMessager say: 1 31 0 0) ; "No way! You're not getting this pillow back! You gave it to me fair and square! A deal's a deal!"
			else
				(gMessager say: 1 28 0 0) ; "I'm already sitting on a tile. Most uncomfortable!"
			)
			(return)
		)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTalkToVeder)
			)
			(37 ; ioHaremPillow
				(gEgo setScript: soTorinGivesPillow)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(= gtVeder 0)
		(super dispose: &rest)
	)
)

(instance soTalkToVeder of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo face: poMan self)
			)
			(1
				(gGame handsOff:)
				(switch gnVederTalk
					(0
						(= gnVederTalk 1)
					)
					(1
						(= gnVederTalk 2)
					)
					(2
						(= gnVederTalk 3)
					)
					(3
						(= gnVederTalk 4)
					)
					(4
						(= gnVederTalk 5)
					)
					(5
						(= gnVederTalk 6)
					)
				)
				(cond
					((OneOf gnVederTalk 1 2)
						(self setScript: soTalkDelay self)
					)
					((== gnVederTalk 7)
						(gMessager say: 1 1 gnVederTalk 0 self) ; "Looks like the cushion is working."
					)
					(else
						(gMessager say: 1 1 gnVederTalk 1 self)
					)
				)
			)
			(2
				(if (OneOf gnVederTalk 1 2 7)
					(gGame handsOn:)
					(self dispose:)
				else
					(poMan setCycle: End self)
				)
			)
			(3
				(poMan
					addHotspotVerb:
						33
						1
						36
						40
						37
						34
						39
						27
						32
						24
						30
						31
						29
						25
						48
						28
						26
				)
				(switch gnVederTalk
					(3
						(gMessager sayRange: 1 1 3 2 4 self) ; "What? (PAUSE) Who are you? (PAUSE) And why are you here?"
					)
					(4
						(gMessager sayRange: 1 1 4 2 9 self) ; "Name? Veder. Is this why you come here? To torment me with unimportant questions? Where are the real questions? The ones aching deep inside you? Who are you? What do you believe? What do you know?"
					)
					(5
						(gMessager sayRange: 1 1 5 2 4 self) ; "Do you know how to help "The Area Below?""
					)
					(6
						(gMessager sayRange: 1 1 6 2 5 self) ; "Uncomfortable don't cut it! My seat's boiling. My buns're burning. Oye, I need relief!"
					)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTalkDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 1 gnVederTalk 1 self)
			)
			(1
				(= ticks 180)
			)
			(2
				(gMessager say: 1 1 gnVederTalk 2 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance poTorinGivesPillow of Prop
	(properties
		x 416
		y 226
		view 20103
		loop 3
	)
)

(instance poManTakesPillow of Prop
	(properties
		x 334
		y 184
		view 20103
		loop 4
	)
)

(instance soTorinGivesPillow of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 416 226 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gGame handsOff:)
				(gMessager say: 1 37 0 1 self) ; "Here's a thick, soft cushion that I think you'll like."
			)
			(3
				(gEgo hide:)
				(poMan dispose:)
				(poTorinGivesPillow setCel: 0 init: setCycle: End self)
				(poManTakesPillow setCel: 0 init: setCycle: End self)
			)
			(4)
			(5
				(gEgo put: ((ScriptID 64001 0) get: 27)) ; oInvHandler, ioHaremPillow
				(gEgo get: ((ScriptID 64001 0) get: 21)) ; oInvHandler, ioSeatTile
				((ScriptID 64017 0) set: 53 84) ; oFlags
				(= gnVederTalk 7)
				(poTorinGivesPillow dispose:)
				(poManTakesPillow dispose:)
				(poMan init:)
				(gEgo
					posn: 461 215
					setLoop: 5
					setMotion: MoveTo 451 225 self
					show:
				)
			)
			(6
				(gEgo face: poMan self)
			)
			(7
				(gMessager sayRange: 1 37 0 2 4 self) ; "Let me feel...ah, fine materials. Nice padding. Soft cover. Firm, yet breathable. I thank you very much, O tall slender one. And, in return, why don't you take this instrument of my torture."
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voVederBody of View
	(properties
		view 20103
		loop 5
	)

	(method (init)
		(self posn: (poMan x:) (poMan y:))
		(super init: &rest)
		(poMan hide:)
	)

	(method (dispose)
		(poMan show:)
		(super dispose: &rest)
	)
)

(instance toVeder of Talker
	(properties
		view 20103
		loop 6
	)

	(method (init)
		(= x (poMan x:))
		(= y (poMan y:))
		(= priority (+ (poMan priority:) 1))
		(voVederBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(voVederBody dispose:)
		(super dispose: &rest)
	)
)

(instance voVederPillowBody of View
	(properties
		view 20103
		loop 7
	)

	(method (init)
		(self posn: (poMan x:) (poMan y:))
		(super init: &rest)
		(poMan hide:)
	)

	(method (dispose)
		(poMan show:)
		(super dispose: &rest)
	)
)

(instance toVederPillow of Talker
	(properties
		view 20103
		loop 8
	)

	(method (init)
		(= x (poMan x:))
		(= y (poMan y:))
		(= priority (+ (poMan priority:) 1))
		(voVederPillowBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(voVederPillowBody dispose:)
		(super dispose: &rest)
	)
)

(instance roVedarCu of TPRoom
	(properties
		picture 20900
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 20900)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 412 211 353 226 371 233 401 226 464 244 486 237 555 258 538 290 586 324 628 312 633 264 611 248
					yourself:
				)
		)
		((ScriptID 64017 0) set: 83) ; oFlags
		(foExit init:)
		(poMan init:)
		(gEgo
			posn: 626 280
			init:
			normalize: 0 60100 7
			setMotion: MoveTo 543 246 (ScriptID 64020 0) ; oHandsOnWhenCued
		)
		(gGame handsOff:)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 27)) ; oInvHandler, ioHaremPillow
	)
)

