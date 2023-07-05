;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4500)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Inset)
(use Polygon)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4500 0
)

(instance rm4500 of KQRoom
	(properties
		picture 4500
	)

	(method (init)
		(SetFlag 172)
		(SetFlag 192)
		(gKqMusic1 number: 4500 setLoop: -1 play:)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 43 136 270 136 256 131 213 126 126 128 103 120 62 125
					yourself:
				)
		)
		(lid init:)
		(chains init:)
		(wall init:)
		(lock init:)
		(gEgo init: normalize: posn: 183 132)
		(gGame handsOn:)
		(deathTimer setReal: self 60)
		(self setScript: sEnter)
	)

	(method (cue)
		(if (!= script openBox)
			(self setScript: boogeyCome)
		)
	)
)

(instance lid of Prop
	(properties
		x 148
		y 122
		view 4500
		signal 16385
	)
)

(instance lock of Prop
	(properties
		sightAngle 10
		x 176
		y 108
		priority 126
		fixPriority 1
		view 4502
		loop 3
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 46 ; Do, Exit, Hammer_and_Chisel
			approachVerbs: 8 46 ; Do, Hammer_and_Chisel
			approachX: 201
			approachY: 128
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setInset: lockInset 0 0 1)
				((gCurRoom inset:) drawInset:)
			)
			(46 ; Hammer_and_Chisel
				(gCurRoom setScript: poundLock)
			)
		)
	)
)

(instance lockList of List
	(properties)
)

(instance lockSymbol of Prop
	(properties)

	(method (init)
		(= view 4710)
		(super init:)
		(= signal (| $5000 signal))
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb)
		(if (not cel)
			(self setCel: 1)
			(UpdateScreenItem self)
			(FrameOut)
			(lockList add: self)
			(if (== (lockList size:) 3)
				(if
					(and
						(== ((lockList at: 0) loop:) 2)
						(== ((lockList at: 1) loop:) 4)
						(== ((lockList at: 2) loop:) 6)
					)
					(gKqSound1 number: 810 setLoop: 1 play: openBox)
					(gCurRoom setScript: openBox)
					(return)
				else
					(lockList eachElementDo: #cel 0 release:)
				)
			)
			(gKqSound1 number: 810 setLoop: 1 play:)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(lockList eachElementDo: #cel 0 release:)
	)
)

(instance lockInset of Inset
	(properties
		picture 4710
		priority 500
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 oldTimers)
		(= oldTimers gTimers)
		(= gTimers temp0)
		(lockList add:)
		(proc11_6)
		((lockSymbol new:) loop: 1 x: 118 y: 55 init:)
		((lockSymbol new:) loop: 2 x: 156 y: 48 init:)
		((lockSymbol new:) loop: 3 x: 174 y: 59 init:)
		((lockSymbol new:) loop: 4 x: 186 y: 80 init:)
		((lockSymbol new:) loop: 5 x: 177 y: 103 init:)
		((lockSymbol new:) loop: 6 x: 153 y: 119 init:)
		((lockSymbol new:) loop: 7 x: 131 y: 119 init:)
		((lockSymbol new:) loop: 8 x: 119 y: 104 init:)
		((lockSymbol new:) loop: 9 x: 104 y: 76 init:)
	)

	(method (dispose &tmp temp0)
		(= temp0 oldTimers)
		(= oldTimers gTimers)
		(= gTimers temp0)
		(lockList release: dispose:)
		(super dispose:)
	)
)

(instance chains of Prop
	(properties
		x 178
		y 125
		priority 123
		fixPriority 1
		view 4500
		loop 1
	)
)

(instance boogeyMan of Prop
	(properties
		view 43510
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 865) ; WAVE
				(gEgo
					view: 4504
					cel: 0
					loop: 0
					posn: 183 132
					init:
					setCycle: CT 9 1 self
				)
			)
			(1
				(gKqSound1 number: 865 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo heading: 315 normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance boogeyCome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCurRoom inset:)
					(gCurRoom setInset:)
				)
				(= cycles 1)
			)
			(1
				(gKqSound1 number: 4353 setLoop: 1 play:)
				(= register (Prop new:))
				(register
					view: 4503
					loop: 5
					x: (gEgo x:)
					y: 148
					init:
					setCycle: End self
				)
			)
			(2
				(register dispose:)
				(= ticks 30)
			)
			(3
				(boogeyMan
					x: (gEgo x:)
					y: (gEgo y:)
					setPri: (- (gEgo priority:) 1)
					loop: 2
					cel: 0
					init:
					setCycle: End self
				)
				(gEgo setMotion: 0)
			)
			(4
				(gKqSound1 number: 4402 setLoop: 1 play: self)
				(gEgo hide:)
				(boogeyMan view: 43512 loop: 0 cel: 0 setCycle: End self)
			)
			(5)
			(6
				(gKqSound1 stop:)
				(EgoDead 19 self)
			)
			(7
				(gCurRoom newRoom: 4350)
			)
		)
	)
)

(instance climbWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 4502 loop: 0 cel: 0 setCycle: CT 25 1 self)
			)
			(2
				(gEgo setCycle: End self)
				(gKqSound1 number: 825 setLoop: 1 play: self)
			)
			(3)
			(4
				(gEgo normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poundLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo
					view: 4502
					loop: 4
					cel: 0
					x: 201
					y: 128
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 4502
					loop: 1
					cel: 0
					x: 201
					y: 128
					setCycle: End self
				)
				(deathTimer setReal: gCurRoom 10)
			)
			(3
				(gEgo cel: 0 setCycle: End self)
				(gKqSound1 number: 874 setLoop: 1 play:)
				(-- state)
			)
		)
	)
)

(instance openBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
			)
			(1
				(gCurRoom setInset:)
				(gEgo setHeading: 0 self)
				(gKqSound1 number: 4711 setLoop: 1 play:)
				(lock setCycle: End self)
			)
			(2)
			(3
				(gKqSound1 stop:)
				(lock dispose:)
				(gEgo setMotion: MoveTo 175 125 self)
			)
			(4
				(gEgo setHeading: 0 self)
			)
			(5
				(gEgo view: 4502 loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(gEgo setCycle: Beg)
				(chains setCycle: End self)
				(gKqSound1 number: 4504 setLoop: 1 play:)
			)
			(7
				(gKqSound1 stop:)
				((= scratch (Prop new:))
					view: 4502
					loop: 5
					cel: 0
					x: 138
					y: 113
					setPri: 0
					init:
				)
				(gEgo
					normalize: 3
					x: 175
					y: 125
					setMotion: MoveTo 161 125 self
				)
			)
			(8
				(gEgo setHeading: 0 self)
			)
			(9
				(chains setPri: 120)
				(gEgo hide:)
				(lid
					view: 45020
					loop: 0
					cel: 0
					x: 148
					y: 122
					setCycle: End self
				)
				(gKqSound1 number: 4505 setLoop: 1 play:)
			)
			(10
				(gKqSound1 stop:)
				(lid view: 4500 loop: 0)
				(lid cel: (lid lastCel:) x: 148 y: 122)
				(gEgo view: 45020 loop: 1 cel: 0 x: 148 y: 123)
				(gEgo show: setCycle: End self)
			)
			(11
				(gEgo x: 194 y: 133 normalize: 3 setMotion: MoveTo 165 120)
				(= cycles 2)
			)
			(12
				(gMessager say: 0 0 1 1 self) ; "(URGENTLY)Your majesty? King Otar?"
			)
			(13
				(scratch setCycle: End self)
				(gMessager say: 0 0 1 2 self) ; "(REALLY SURPRISED)Yes! Who--"
			)
			(14)
			(15
				(if (gEgo mover:)
					(-- state)
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(16
				(gKqMusic1 number: 4506 setLoop: 1 play:)
				(= ticks 30)
			)
			(17
				(gEgo setHeading: 180 self)
			)
			(18
				(scratch view: 4503 loop: 6 cel: 0 setCycle: End self)
				(gEgo view: 8572 loop: 0 cel: 0 y: 115 setCycle: End)
				((= register (Prop new:))
					view: 4503
					loop: 0
					cel: 0
					x: 90
					y: 140
					init:
					setCycle: CT 9 1 self
				)
				((ScriptID 7001 1) client: register view: 4503 loop: 8) ; maliciaTalker
				(gKqSound1 number: 816 setLoop: 1 play:)
			)
			(19)
			(20
				(scratch loop: 7 cel: 0 setCycle: End self)
				(gMessager say: 0 0 1 3 self) ; "(COOL AND VERY NASTY)Hello, my little moles. I hope you two get along, since you're going to spend the next thousand years together."
			)
			(21)
			(22
				(register setCycle: End self)
				((ScriptID 7001 1) client: 0 view: -1 loop: -1) ; maliciaTalker
			)
			(23
				(lid setCycle: Beg self)
				(gKqSound1 number: 4505 setLoop: 1 play:)
			)
			(24
				(gKqSound1 stop:)
				(chains setPri: 123 setCycle: Beg self)
				(gKqSound1 number: 4507 setLoop: 1 play:)
			)
			(25
				(gKqSound1 number: 4711 setLoop: 1 play:)
				(lock init: setCycle: Beg self)
			)
			(26
				(gKqSound1 stop:)
				(register setCycle: Beg self)
				(gKqSound1 number: 816 setLoop: 1 play:)
			)
			(27
				(register dispose:)
				(= seconds 3)
			)
			(28
				(gGame handsOn:)
				(gCurRoom newRoom: 4350)
			)
		)
	)
)

(instance wall of ExitFeature
	(properties
		nsRight 320
		nsBottom 20
		approachY 100
		exitDir 1
	)

	(method (handleEvent event)
		(if (< (event x:) 160)
			(= approachX (Min (event x:) 85))
		else
			(= approachX (Max (event x:) 230))
		)
		(super handleEvent: event)
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 10 8) ; Do, Exit, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: climbWall)
	)
)

(instance deathTimer of Timer
	(properties)

	(method (setReal param1)
		(if (and param1 (param1 respondsTo: #timer) (param1 timer:))
			((param1 timer:) dispose:)
			(param1 timer: 0)
		)
		(super setReal: param1 &rest)
	)
)

(instance sfx of Sound ; UNUSED
	(properties)
)

