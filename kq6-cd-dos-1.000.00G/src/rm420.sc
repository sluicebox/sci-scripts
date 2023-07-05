;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use rLab)
(use KQ6Room)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm420 0
)

(local
	local0
	local1
)

(instance myConv of Conversation
	(properties)
)

(instance rm420 of KQ6Room
	(properties
		noun 2
		picture 420
		style 10
		walkOffEdge 1
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 194 120 122 120 116 122 54 122 50 125 110 125 96 130 96 150 221 150 220 132 204 125 245 125 243 122 198 122
					yourself:
				)
		)
		(super init: &rest)
		(LoadMany rsVIEW 421)
		(gEgo init: setScale: Scaler 100 60 128 100 actions: egoDoCrushCode)
		((ScriptID 30 0) cue:) ; rLab
		(gFeatures add: floor walls exits eachElementDo: #init)
		(if (= local0 (== ((gInventory at: 2) owner:) gCurRoomNum)) ; brick
			(= local1 5)
			(theBrick addToPic:)
			(gears addToPic:)
			(ceiling addToPic:)
		else
			(= local1 4)
			(eastDoor init:)
			(westDoor init:)
			(gears init: stopUpd:)
			(ceiling init: stopUpd:)
		)
		(if (not (rLab prevEdgeHit:))
			(rLab prevEdgeHit: EDGE_RIGHT)
		)
		(self setScript: walkIn)
	)

	(method (doit)
		(cond
			((self script:))
			((== (gEgo onControl: 1) 16384)
				((ScriptID 30 0) prevEdgeHit: EDGE_RIGHT) ; rLab
				(self setScript: walkOut)
			)
			((== (gEgo onControl: 1) 8192)
				((ScriptID 30 0) prevEdgeHit: EDGE_LEFT) ; rLab
				(self setScript: walkOut)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1 ; Look
					(gMessager say: 2 1 local1 1)
					1
				)
				(2 ; Talk
					(if local0
						(gMessager say: 2 2 local1 1)
						1
					else
						(myConv add: -1 2 2 local1 1 add: -1 2 2 local1 2 init:)
						1
					)
				)
				(5 ; Do
					(gMessager say: 2 5 local1 1)
					1
				)
				(else
					(gMessager say: 2 0 local1 1)
					1
				)
			)
		)
	)

	(method (scriptCheck &tmp temp0)
		(= temp0 1)
		(if (not local0)
			(gMessager say: 0 0 164 1 0 899) ; "A trap room is no place to do that! Alexander should wait until he's somewhere a bit safer."
			(= temp0 0)
		)
		(return temp0)
	)
)

(instance floor of Feature
	(properties
		noun 8
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMessager say: 8 5 local1 1)
			)
			(1 ; Look
				(gMessager say: 8 1 0 1) ; "The floor in this room looks like every other floor in the catacombs. It's made of solid rock."
			)
			(2 ; Talk
				(gMessager say: 8 2 local1 0)
			)
			(else
				(gMessager say: 2 0 local1 1)
			)
		)
	)
)

(instance walls of Feature
	(properties
		noun 7
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1 local1 1)
			)
			(5 ; Do
				(gMessager say: 7 5 local1 1)
			)
			(2 ; Talk
				(if local0
					(gMessager say: 2 2 local1 0)
				else
					(gMessager say: 7 2 local1 0)
				)
			)
			(else
				(gMessager say: 2 0 local1 1)
			)
		)
	)
)

(instance exits of Feature
	(properties
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(westDoor doVerb: theVerb &rest)
	)
)

(instance gears of Prop
	(properties
		x 160
		y 118
		noun 6
		view 424
		loop 1
		signal 16400
		cycleSpeed 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 local1 1)
			)
			(5 ; Do
				(gMessager say: 6 5 local1 1)
			)
			(2 ; Talk
				(gMessager say: 6 2 local1 1)
			)
			(39 ; brick
				(gCurRoom setScript: useBrick)
			)
			(51 ; skull
				(if local0
					(gMessager say: 6 0 local1 1)
				else
					(gCurRoom setScript: throwSkull)
				)
			)
			(17 ; shield
				(if local0
					(gMessager say: 6 0 local1 1)
				else
					(gMessager say: 6 17 local1 1)
				)
			)
			(28 ; spellBook
				(if local0
					(gMessager say: 6 0 local1 1)
				else
					(gMessager say: 6 28 local1 1)
				)
			)
			(36 ; ???
				(if local0
					(gMessager say: 6 0 local1 1)
				else
					(gMessager say: 6 36 local1 1)
				)
			)
			(42 ; boringBook
				(if local0
					(gMessager say: 6 0 local1 1)
				else
					(gMessager say: 6 42 local1 1)
				)
			)
			(20 ; tinderBox
				(if local0
					(gMessager say: 6 0 local1 1)
				else
					(gMessager say: 6 20 local1 1)
				)
			)
			(34 ; tomato
				(if local0
					(gMessager say: 6 0 local1 1)
				else
					(gMessager say: 6 34 local1 1)
				)
			)
			(94 ; participle
				(if local0
					(gMessager say: 6 0 local1 1)
				else
					(gMessager say: 6 94 local1 1)
				)
			)
			(else
				(gMessager say: 6 0 local1 1)
			)
		)
	)
)

(instance ceiling of Prop
	(properties
		x 162
		y 71
		noun 4
		view 424
		priority 7
		signal 20496
		cycleSpeed 12
	)

	(method (addToPic)
		(self
			y: ((ScriptID 30 0) crushCeilingY:) ; rLab
			cel: ((ScriptID 30 0) crushCeilingCel:) ; rLab
		)
		(super addToPic:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1 local1 1)
			)
			(5 ; Do
				(gMessager say: 4 5 local1 1)
			)
			(2 ; Talk
				(gMessager say: 4 2 local1 1)
			)
			(51 ; skull
				(if local0
					(gMessager say: 4 0 local1 1)
				else
					(gMessager say: 4 51 local1 1)
				)
			)
			(17 ; shield
				(if local0
					(gMessager say: 4 0 local1 1)
				else
					(gMessager say: 4 17 local1 1)
				)
			)
			(28 ; spellBook
				(if local0
					(gMessager say: 4 0 local1 1)
				else
					(gMessager say: 4 28 local1 1)
				)
			)
			(94 ; participle
				(if local0
					(gMessager say: 4 0 local1 1)
				else
					(gMessager say: 4 94 local1 1)
				)
			)
			(12 ; map
				(gMessager say: 4 12 0 1) ; "Alexander can't use the magic map on the ceiling."
			)
			(else
				(gMessager say: 4 0 local1 1)
			)
		)
	)
)

(instance westDoor of Prop
	(properties
		x 101
		y 71
		noun 5
		view 424
		loop 2
		signal 20480
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1 local1 1)
			)
			(5 ; Do
				(gMessager say: 5 5 local1 1)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 5 0 local1 1)
			)
		)
	)
)

(instance eastDoor of Prop
	(properties
		x 211
		y 70
		noun 5
		view 424
		loop 3
		signal 20480
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(westDoor doVerb: theVerb &rest)
	)
)

(instance theBrick of Prop
	(properties
		noun 10
		view 424
		loop 5
		signal 16384
		cycleSpeed 1
	)

	(method (init)
		(if (== ((gInventory at: 2) owner:) gCurRoomNum) ; brick
			(self x: 169 y: 119 z: 32)
		else
			(self x: 169 y: 118)
		)
		(super init:)
	)
)

(instance theSkull of Prop
	(properties
		x 166
		y 118
		view 424
		loop 4
		cycleSpeed 1
	)
)

(instance cog of Prop
	(properties
		x 182
		y 133
		view 423
		signal 16384
		cycleSpeed 5
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable: 6)
				(switch (rLab prevEdgeHit:)
					(2
						(gEgo edgeHit: EDGE_RIGHT setMotion: MoveTo 232 123 self)
					)
					(4
						(gEgo edgeHit: EDGE_LEFT setMotion: MoveTo 82 123 self)
					)
				)
			)
			(1
				(gCurRoom newRoom: 400) ; LBRoom
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch (rLab prevEdgeHit:)
					(4
						(gEgo posn: 232 123 setMotion: PolyPath 194 123 self)
					)
					(2
						(gEgo posn: 82 123 setMotion: PolyPath 122 123 self)
					)
				)
			)
			(1
				(if local0
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setPri: 14 setMotion: PolyPath 152 134 self)
				)
			)
			(2
				(gEgo setHeading: 90)
				(eastDoor setCycle: End)
				(westDoor setCycle: End self)
				(gGlobalSound4 number: 426 setLoop: 1 play:)
			)
			(3
				(gGame handsOn:)
				(gTheIconBar enable: 6 disable: 0)
				(gGlobalSound number: 420 setLoop: -1 play: self)
				(gGlobalSound2 number: 421 setLoop: -1 play: self)
				(= ticks 4)
			)
			(4
				(eastDoor stopUpd:)
				(westDoor stopUpd:)
				(gMessager say: 1 0 1 1 self) ; "It's a trap! The doors have sealed Alexander inside!"
			)
			(5
				(ceiling startUpd: y: (+ (ceiling y:) 1))
				(gears setCycle: Fwd)
				(= cycles 4)
			)
			(6
				(gMessager say: 1 0 1 2 self) ; "And the ceiling is coming down!"
			)
			(7
				(self setScript: dropCeiling self 1)
			)
			(8
				(ceiling stopUpd:)
				(= seconds 1)
			)
			(9
				(gCurRoom setScript: sqwishEm)
			)
		)
	)
)

(instance dropCeiling of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(ceiling startUpd: y: (+ (ceiling y:) 1))
				(= seconds 2)
			)
			(1
				(if (== register 1)
					(= temp0 85)
				else
					(= temp0 91)
				)
				(if (< (ceiling y:) temp0)
					(self changeState: 0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance throwSkull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 51 4 1 self) ; "Desperate to stop the crushing ceiling, Alexander throws a skull into the grinding gears."
			)
			(1
				(gEgo view: 421 normal: 0 setLoop: 1 cel: 4 posn: 162 146)
				(= ticks 4)
			)
			(2
				(gEgo cel: 5)
				(theSkull init:)
				(= ticks 4)
			)
			(3
				(gEgo cel: 6)
				(= ticks 4)
			)
			(4
				(gEgo cel: 7)
				(theSkull posn: 161 124)
				(theSkull posn: (- (theSkull x:) 8) (+ (theSkull y:) 6))
				(= ticks 4)
			)
			(5
				(gEgo cel: 8)
				(theSkull
					setPri: 11
					posn: (- (theSkull x:) 10) (- (theSkull y:) 3)
				)
				(= ticks 4)
			)
			(6
				(gEgo cel: 9)
				(theSkull
					setPri: -1
					posn: (+ (theSkull x:) 26) (- (theSkull y:) 3)
				)
				(= ticks 4)
			)
			(7
				(gEgo cel: 10)
				(theSkull posn: (- (theSkull x:) 5) (- (theSkull y:) 18))
				(= ticks 2)
			)
			(8
				(theSkull cel: 1 posn: (+ (theSkull x:) 1) (- (theSkull y:) 6))
				(= ticks 2)
			)
			(9
				(theSkull cel: 2 posn: (+ (theSkull x:) 1) (- (theSkull y:) 5))
				(= ticks 2)
			)
			(10
				(theSkull cel: 3 posn: (+ (theSkull x:) 1) (- (theSkull y:) 7))
				(= ticks 2)
			)
			(11
				(theSkull cel: 0 posn: (+ (theSkull x:) 1) (- (theSkull y:) 5))
				(= ticks 2)
			)
			(12
				(theSkull cel: 1 posn: (+ (theSkull x:) 1) (+ (theSkull y:) 2))
				(= ticks 2)
			)
			(13
				(theSkull cel: 2 posn: (+ (theSkull x:) 1) (+ (theSkull y:) 2))
				(= ticks 2)
			)
			(14
				(theSkull cel: 3 posn: (+ (theSkull x:) 1) (+ (theSkull y:) 1))
				(= ticks 2)
			)
			(15
				(gGlobalSound stop:)
				(gGlobalSound2 stop:)
				(gGlobalSound4 number: 422 setLoop: 1 play: self)
				(gGlobalSound3 number: 424 setLoop: 1 play:)
				(theSkull cel: 0 posn: (+ (theSkull x:) 1) (+ (theSkull y:) 4))
			)
			(16
				(theSkull posn: (- (theSkull x:) 1) (- (theSkull y:) 1))
				(gMessager say: 6 51 4 2 self) ; "The skull is caught between two cogs...."
			)
			(17
				(gears setCycle: 0 stopUpd:)
				(gEgo reset: 0 posn: 155 134)
				(gMessager say: 6 51 4 3 self) ; "....The gears shriek and shutter...."
			)
			(18
				(gMessager say: 6 51 4 4 self) ; "....The skull begins to bulge!"
			)
			(19
				(= seconds 2)
			)
			(20
				(theSkull setLoop: 6 setCycle: End self)
				(gGlobalSound4 number: 423 setLoop: 1 play: self)
			)
			(21
				(gGlobalSound number: 420 setLoop: -1 play: self)
				(gGlobalSound2 number: 421 setLoop: -1 play: self)
			)
			(22
				(gears setCycle: Fwd)
				(gMessager say: 6 51 4 5 self) ; "UH, OH!!!"
			)
			(23
				(theSkull dispose:)
				(gTheIconBar disable: 0)
				(gEgo put: 11 gCurRoomNum) ; skull
				(ceiling y: 84)
				(= seconds 2)
			)
			(24
				(gCurRoom setScript: sqwishEm 0 1)
			)
		)
	)
)

(instance sqwishEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 0 3 1 self) ; "With a sudden lurch, the ceiling completes its descent."
			)
			(1
				(ceiling setPri: 12 setCycle: CT 3 1 self)
				(gEgo
					view: 421
					normal: 0
					setLoop: 2
					cel: 0
					cycleSpeed: 6
					setPri: 14
					posn: (- (gEgo x:) 2) (+ (gEgo y:) 4)
					setCycle: End self
				)
			)
			(2
				(ceiling cel: (+ (ceiling cel:) 1))
				(gEgo setPri: 13 setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(ceiling cel: (+ (ceiling cel:) 1))
				(gEgo setLoop: 4 cel: 0 setCycle: CT 4 1 self)
			)
			(4
				(gMessager say: 1 0 3 2 self) ; "YIKES!"
			)
			(5
				(ceiling setPri: 14 cel: (+ (ceiling cel:) 1))
				(gEgo setCycle: CT 7 1 self)
			)
			(6
				(ceiling cel: (+ (ceiling cel:) 1))
				(gEgo setCycle: CT 8 1 self)
			)
			(7
				(gMessager say: 1 0 3 3 self) ; "And presses Alexander into the floor like a bug under a heel!"
			)
			(8
				(ceiling setCycle: End self)
			)
			(9
				(gGlobalSound stop:)
				(gGlobalSound2 stop:)
				(gGlobalSound4 number: 425 setLoop: 1 play:)
				(= cycles 6)
			)
			(10
				(ceiling stopUpd:)
				(if register
					(gMessager say: 6 51 4 6 self) ; "That skull wasn't strong enough to endure the pressure...and neither is Alexander's!"
				else
					(self cue:)
				)
			)
			(11
				(gGame handsOn:)
				(EgoDead 9) ; "Alexander never was much good at SQUASH!"
			)
		)
	)
)

(instance useBrick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 39 0 1 self) ; "In a desperate move, Alexander throws a brick into the grinding gears!"
			)
			(1
				(gEgo view: 421 normal: 0 setLoop: 0 cel: 4 posn: 162 146)
				(= ticks 2)
			)
			(2
				(gEgo cel: 5)
				(theBrick init:)
				(= ticks 2)
			)
			(3
				(gEgo cel: 6)
				(theBrick posn: (- (theBrick x:) 2) (- (theBrick y:) 4))
				(= ticks 2)
			)
			(4
				(gEgo cel: 7)
				(theBrick posn: (- (theBrick x:) 10) (+ (theBrick y:) 8))
				(= ticks 2)
			)
			(5
				(gEgo cel: 8)
				(theBrick
					setPri: 11
					posn: (- (theBrick x:) 7) (- (theBrick y:) 3)
				)
				(= ticks 2)
			)
			(6
				(gEgo cel: 9)
				(theBrick
					setPri: -1
					posn: (+ (theBrick x:) 24) (- (theBrick y:) 1)
				)
				(= ticks 2)
			)
			(7
				(gEgo cel: 10)
				(theBrick posn: (- (theBrick x:) 4) (- (theBrick y:) 19))
				(= ticks 2)
			)
			(8
				(theBrick cel: 1 posn: (+ (theBrick x:) 1) (- (theBrick y:) 6))
				(= ticks 2)
			)
			(9
				(theBrick cel: 2 posn: (theBrick x:) (- (theBrick y:) 5))
				(= ticks 2)
			)
			(10
				(theBrick cel: 3 posn: (theBrick x:) (- (theBrick y:) 6))
				(= ticks 2)
			)
			(11
				(theBrick cel: 0 posn: (theBrick x:) (- (theBrick y:) 4))
				(= ticks 2)
			)
			(12
				(theBrick cel: 1 posn: (theBrick x:) (+ (theBrick y:) 3))
				(= ticks 2)
			)
			(13
				(theBrick cel: 2 posn: (theBrick x:) (+ (theBrick y:) 3))
				(= ticks 2)
			)
			(14
				(theBrick cel: 3 posn: (theBrick x:) (+ (theBrick y:) 2))
				(= ticks 2)
			)
			(15
				(gGlobalSound stop:)
				(gGlobalSound2 stop:)
				(gGlobalSound4 number: 422 setLoop: 1 play: self)
				(gGlobalSound3 number: 424 setLoop: 1 play:)
				(theBrick cel: 0 posn: (theBrick x:) (+ (theBrick y:) 2))
			)
			(16
				(theBrick x: 169 y: 119 z: 32 stopUpd:)
				(gMessager say: 6 39 0 2 self) ; "The brick is caught between two cogs! The gears shriek and shutter!"
			)
			(17
				(gears setCycle: 0 stopUpd:)
				(cog init: setCycle: End self)
				(gEgo reset: 0 posn: 155 134)
			)
			(18
				(gMessager say: 6 39 0 3 self) ; "The mechanism grinds to a halt! The ceiling is stuck!"
			)
			(19
				(gGame givePoints: 2)
				(cog dispose:)
				(gGlobalSound4 number: 426 setLoop: 1 play:)
				(eastDoor setCycle: Beg)
				(westDoor setCycle: Beg self)
			)
			(20
				(gMessager say: 6 39 0 4 self) ; "The trap is sprung!"
			)
			(21
				((ScriptID 30 0) crushCeilingCel: (ceiling cel:)) ; rLab
				((ScriptID 30 0) crushCeilingY: (ceiling y:)) ; rLab
				(= local0 1)
				(= local1 5)
				(ceiling stopUpd:)
				(gGlobalSound number: 400 play:)
				(gGame handsOn:)
				(gEgo put: 2 gCurRoomNum) ; brick
				(self dispose:)
			)
		)
	)
)

(instance egoDoCrushCode of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(17 ; shield
				(gMessager say: 3 17 local1 1)
				(return 1)
			)
			(12 ; map
				(gMessager say: 3 12 0 1) ; "The magic map won't work inside the catacombs."
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

