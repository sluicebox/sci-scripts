;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51200)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use foEExit)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roLycentiasPorch 0
)

(local
	bEgoOnPorch
)

(instance foNullVoidExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 485 187 407 319 633 318 634 -2 492 -2 485 44 570 96 516 203
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExit)
	)
)

(instance foInside of Feature
	(properties
		x 344
		y 203
	)

	(method (init)
		(foNullVoidExit dispose:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 348 115 269 249 265 277 332 291 424 153
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Do
			(gCurRoom setScript: soGoInside)
		)
	)
)

(instance foDoorbell of Feature
	(properties
		x 295
		y 162
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 286 155 286 170 304 170 304 155
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (not (gCurRoom script:))) ; Do
			(gCurRoom setScript: soRingDoorbell)
		)
	)
)

(instance foDoorstep of Feature
	(properties
		sightAngle 40
		x 430
		y 136
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 348 113 422 151 484 160 512 154 424 123
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (not bEgoOnPorch)) ; Do
			(poTorinStop setScript: soOnPorch)
		)
	)
)

(instance foDoorbottom of Feature
	(properties
		sightAngle 40
		x 453
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 373 73 431 87 513 121 533 104 386 29
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) bEgoOnPorch) ; Do
			(poTorinStop setScript: soUnderPorch)
		)
	)
)

(instance poTorinStop of Prop
	(properties
		x 479
		y 146
		view 51201
		loop 6
	)
)

(instance poTorin of Prop
	(properties
		x 479
		y 146
		view 51201
	)
)

(instance poDreep of Prop
	(properties
		x 361
		y 113
		priority 120
		fixPriority 1
		view 51220
	)
)

(instance poDoor of Prop
	(properties
		x 289
		y 285
		priority 100
		fixPriority 1
		view 51210
	)

	(method (init)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 223) ; oFlags
			(= cel (self lastCel:))
			(foInside init:)
		else
			(= cel 0)
		)
	)
)

(instance soGoInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not bEgoOnPorch)
					(self setScript: soOnPorch self)
				else
					(= ticks 1)
				)
			)
			(1
				(poTorinStop hide:)
				(poTorin
					setLoop: 5
					setCel: 0
					init:
					setPri: 120
					setCycle: End self
				)
			)
			(2
				((ScriptID 56000 0) reallyDispose:) ; oCrystCorder
				(gCurRoom newRoom: 51300) ; roLycentiasHorrors
				(self dispose:)
			)
		)
	)
)

(instance soOnPorch of Script
	(properties)

	(method (dispose)
		(poTorinStop setPri: 200 setLoop: 6 show:)
		(poTorin dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= bEgoOnPorch 1)
				(poTorinStop hide:)
				(poTorin setCel: 0 setLoop: 3 init: setCycle: CT 1 1 self)
			)
			(1
				(poTorin setPri: 200 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soUnderPorch of Script
	(properties)

	(method (dispose)
		(poTorinStop setPri: 10 setLoop: 7 show:)
		(poTorin dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= bEgoOnPorch 0)
				(poTorinStop hide:)
				(poTorin setLoop: 2 setCel: 0 init: setCycle: CT 15 1 self)
			)
			(1
				(poTorin setPri: 10 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soRingDoorbell of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not bEgoOnPorch)
					(self setScript: soOnPorch self)
				else
					(= ticks 1)
				)
			)
			(1
				(poTorinStop hide:)
				(poTorin setLoop: 1 setCel: 0 init: setCycle: CT 12 1 self)
			)
			(2
				(poTorin setCycle: End self)
				(goSound1 playSound: 51201)
				((ScriptID 64017 0) set: 221) ; oFlags
			)
			(3
				(gGame handsOn:)
				(gMessager say: 0 0 4 0 self) ; "(MUFFLED, AS IF INSIDE A DOOR) Dreep!"
			)
			(4
				(poTorinStop show:)
				(poTorin dispose:)
				(= ticks 300)
			)
			(5
				(if (not ((ScriptID 64017 0) test: 223)) ; oFlags
					(self setScript: soTimesUp self)
				else
					(= ticks 1)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance soTimesUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 playSound: 51202)
				(poDoor setCel: 0 init: setCycle: End self)
			)
			(1
				(goSound1 stop:)
				(if bEgoOnPorch
					(self setScript: soDreepEatTorin self)
				else
					((ScriptID 64017 0) set: 222) ; oFlags
					(if
						(and
							((ScriptID 64017 0) test: 217) ; oFlags
							((ScriptID 64017 0) test: 215) ; oFlags
							((ScriptID 64017 0) test: 216) ; oFlags
						)
						(self setScript: soDreepLeave self)
					else
						(self setScript: soDreepLook self)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDreepLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 2 0 self) ; "(CONFUSED WHO RANG THE DOORBELL) Usqfpg? Dawrb? Saqfp."
			)
			(1
				(poDreep view: 51221 setCel: 0 init: setCycle: CT 9 1 self)
			)
			(2
				(= ticks 45)
			)
			(3
				(poDreep setCycle: CT 12 1 self)
			)
			(4
				(= ticks 45)
			)
			(5
				(poDreep setCycle: CT 15 1 self)
			)
			(6
				(= ticks 45)
			)
			(7
				(poDreep setCycle: CT 17 1 self)
			)
			(8
				(= ticks 90)
			)
			(9
				(poDreep setCycle: End self)
			)
			(10
				(poDreep dispose:)
				(goSound1 playSound: 51203)
				(poDoor setCycle: Beg self)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance soDreepJumpOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poDreep
					posn: 375 101
					view: 51222
					setCel: 0
					init:
					setCycle: CT 3 1 self
				)
			)
			(1
				(poDreep setPri: 200)
				(= ticks 45)
			)
			(2
				(poDreep setCycle: End self)
			)
			(3
				(poDreep dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soDreepLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 3 0 self) ; "(CONFUSED, CONCERNED, OBEYING) Wfqpfo? Wfpqfo! Yfpsids."
				(self setScript: soDreepJumpOut self)
			)
			(1)
			(2
				((ScriptID 64017 0) set: 223) ; oFlags
				(foInside init:)
				(self dispose:)
			)
		)
	)
)

(instance soDreepMunch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poDreep setCycle: CT 19 1 self)
			)
			(1
				(= ticks 90)
			)
			(2
				(poDreep setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soDreepEatTorin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poDreep view: 51220 setCel: 0 init: setCycle: CT 5 1 self)
				(poTorinStop hide:)
			)
			(1
				(gMessager say: 0 0 1 1 self) ; "(MEAN MAD GOTCHA! AS YOU CAPTURE TORIN) Awrggh! Grunt. Ugh."
				(self setScript: soDreepMunch self)
			)
			(2)
			(3
				(poDreep dispose:)
				(if ((ScriptID 64019 0) show: 0 42 1) ; DeathDialog
					(goSound1 playSound: 51203)
					(poDoor setCycle: Beg self)
				)
			)
			(4
				(poTorinStop show:)
				(self dispose:)
			)
		)
	)
)

(instance soExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not bEgoOnPorch)
					(self setScript: soOnPorch self)
				else
					(= ticks 1)
				)
			)
			(1
				(gGame handsOff:)
				(poTorinStop dispose:)
				(poTorin setLoop: 4 setCel: 0 init: setCycle: CT 11 1 self)
			)
			(2
				(goSound1 playSound: (+ 51101 (Random 0 5)))
				(poTorin setCycle: End self)
			)
			(3
				(poTorin dispose:)
				(gCurRoom newRoom: 51100) ; roInsideNullVoid
				(self dispose:)
			)
		)
	)
)

(instance soEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin setLoop: 0 setCel: 0 init: setCycle: End self)
			)
			(1
				(poTorinStop show:)
				(poTorin dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roLycentiasPorch of TPRoom
	(properties
		picture 51200
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 51100)
		(foNullVoidExit init:)
		(foDoorstep init:)
		(foDoorbottom init:)
		(foDoorbell init:)
		(poDoor init:)
		(= bEgoOnPorch 1)
		(poTorinStop view: 51201 setLoop: 6 init: hide:)
		(gCurRoom setScript: soEnter)
	)
)

