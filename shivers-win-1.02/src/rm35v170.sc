;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35170)
(include sci.sh)
(use Main)
(use n951)
(use Movie)
(use Actor)
(use System)

(public
	rm35v170 0
)

(local
	local0
	local1
	local2
)

(instance rm35v170 of ShiversRoom
	(properties
		picture 35170
	)

	(method (init)
		(= local0 0)
		(gSounds fade: 24001 0 5 16 1 0)
		(vMonitor init:)
		(vJoystick init:)
		(vPicture init:)
		(vPlay init:)
		(vStop init:)
		(button1 init:)
		(button2 init:)
		(button3 init:)
		(button4 init:)
		(button5 init:)
		(button6 init:)
		(button7 init:)
		(button8 init:)
		(button9 init:)
		(button10 init:)
		(button11 init:)
		(button12 init:)
		(efExitBack init: 8)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_9 24001)
		(gSounds play: 24001 -1 0 0)
		(gSounds fade: 24001 90 1 30 0 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vMonitor of View
	(properties
		priority 150
		fixPriority 1
		view 35170
		loop 17
	)
)

(instance vJoystick of ShiversProp
	(properties
		priority 254
		fixPriority 1
		view 35170
		cel 4
	)

	(method (init &tmp temp0)
		(= local0 0)
		(super init: &rest)
		(gTheDoits delete: self)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
			)
			(event claimed: 1)
			(self doVerb: 1)
		)
		(if (and (& (event type:) evMOUSERELEASE) (== local0 1) (gUser canControl:))
			(event claimed: 1)
			(self doVerb: 0)
		)
		(super handleEvent: event &rest)
	)

	(method (doit)
		(if (== local0 1)
			(self cel: 0)
			(if (< (- gMouseY 7) 87)
				(self cel: 1)
			)
			(if (> (- gMouseY 7) 93)
				(self cel: 2)
			)
			(if (< (- gMouseX 27) 162)
				(self cel: 4)
			)
			(if (> (- gMouseX 27) 168)
				(self cel: 3)
			)
			(UpdateScreenItem self)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 1)
			(gSounds stop: 13508)
			(gSounds play: 13508 -1 82 0)
			(gTheDoits add: self)
			(= local0 1)
		else
			(gSounds stop: 13508)
			(self cel: 0)
			(UpdateScreenItem self)
			(gTheDoits delete: self)
			(= local0 0)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(class MonitorProp of Prop
	(properties
		priority 254
		fixPriority 1
		view 35170
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(event localize: gThePlane)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(event claimed: 1)
			(self doVerb:)
			(gSounds play: 13504 0 82 0)
			(self cel: 1)
			(if (< (self loop:) 7)
				(vPicture view: 35172 loop: (- (self loop:) 1) x: 0 y: 0)
			else
				(vPicture view: 35171 loop: (- (self loop:) 7) x: 0 y: 0)
			)
			(UpdateScreenItem self)
			(UpdateScreenItem vPicture)
			(if (and (== (vPicture view:) 35172) (== (vPicture loop:) 2))
				(= temp1 (mod global546 100))
				(= temp2 (/ (- global546 temp1) 100))
				(vBigHand cel: (/ temp1 5) init: show:)
				(vLittleHand cel: (mod temp2 12) init: show:)
			else
				(vBigHand cel: 0 init: hide:)
				(vLittleHand cel: 0 init: hide:)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance button1 of MonitorProp
	(properties
		loop 1
	)

	(method (doVerb)
		(proc951_16 114)
	)
)

(instance button2 of MonitorProp
	(properties
		loop 2
	)

	(method (doVerb)
		(proc951_16 115)
	)
)

(instance button3 of MonitorProp
	(properties
		loop 3
	)

	(method (doVerb)
		(proc951_16 116)
	)
)

(instance button4 of MonitorProp
	(properties
		loop 4
	)

	(method (doVerb)
		(proc951_16 117)
	)
)

(instance button5 of MonitorProp
	(properties
		loop 5
	)

	(method (doVerb)
		(proc951_16 118)
	)
)

(instance button6 of MonitorProp
	(properties
		loop 6
	)

	(method (doVerb)
		(proc951_16 119)
	)
)

(instance button7 of MonitorProp
	(properties
		loop 7
	)

	(method (doVerb)
		(proc951_16 120)
	)
)

(instance button8 of MonitorProp
	(properties
		loop 8
	)

	(method (doVerb)
		(proc951_16 121)
	)
)

(instance button9 of MonitorProp
	(properties
		loop 9
	)

	(method (doVerb)
		(proc951_16 122)
	)
)

(instance button10 of MonitorProp
	(properties
		loop 10
	)

	(method (doVerb)
		(proc951_16 123)
	)
)

(instance button11 of MonitorProp
	(properties
		loop 11
	)

	(method (doVerb)
		(proc951_16 124)
	)
)

(instance button12 of MonitorProp
	(properties
		loop 12
	)

	(method (doVerb)
		(proc951_16 125)
	)
)

(instance vPicture of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 35170
		loop 19
	)

	(method (doit &tmp temp0)
		(if (or (== view 35171) (== view 35172))
			(if (IsFlag 35)
				(= temp0 2)
			else
				(= temp0 4)
			)
			(cond
				((== (vJoystick cel:) 1)
					(-= y temp0)
				)
				((== (vJoystick cel:) 2)
					(+= y temp0)
				)
				((== (vJoystick cel:) 3)
					(-= x temp0)
				)
				((== (vJoystick cel:) 4)
					(+= x temp0)
				)
			)
			(if (< x -7)
				(= x -7)
			)
			(if (> x 80)
				(= x 80)
			)
			(if (< y -35)
				(= y -35)
			)
			(if (> y 8)
				(= y 8)
			)
			(vBigHand x: x y: y)
			(vLittleHand x: x y: y)
			(if (vBigHand isNotHidden:)
				(UpdateScreenItem vBigHand)
				(UpdateScreenItem vLittleHand)
			)
			(UpdateScreenItem self)
		)
	)
)

(instance vBigHand of ShiversProp
	(properties
		priority 101
		fixPriority 1
		view 35172
		loop 6
	)
)

(instance vLittleHand of ShiversProp
	(properties
		priority 101
		fixPriority 1
		view 35172
		loop 7
	)
)

(instance vPlay of ShiversProp
	(properties
		priority 254
		fixPriority 1
		view 35170
		loop 14
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doVerb)
		(self setScript: sPlayMovie)
	)
)

(instance vStop of ShiversProp
	(properties
		priority 254
		fixPriority 1
		view 35170
		loop 15
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doVerb))
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 35160
	)

	(method (init)
		(self
			createPoly: 0 124 0 143 262 143 262 113 184 107 122 107 72 111 1 124 1 0 264 0 264 21 189 17 188 5 73 5 73 17 2 25
		)
		(super init: &rest)
	)
)

(instance sPlayMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 13509 0 82 0)
				(client cel: 1)
				(UpdateScreenItem client)
				(= local1 (vPicture view:))
				(= local2 (vPicture loop:))
				(if (and (== local1 35172) (== local2 2))
					(vLittleHand hide:)
					(vBigHand hide:)
				)
				(vPicture view: 35170 loop: 18 x: 0 y: 0)
				(UpdateScreenItem vPicture)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(cond
					((and (== (client loop:) 14) (== local1 35171))
						(cond
							((== local2 3)
								(playMovie doit: 35172)
							)
							((== local2 2)
								(playMovie doit: 35170)
							)
							(else
								(playMovie doit: 35173)
							)
						)
					)
					((== (client loop:) 14)
						(playMovie doit: 35173)
					)
				)
				(= cycles 1)
			)
			(3
				(vPicture view: 35170 loop: 18 x: 0 y: 0)
				(UpdateScreenItem vPicture)
				(= cycles 1)
			)
			(4
				(= seconds 2)
			)
			(5
				(gGame handsOn:)
				(client cel: 0)
				(UpdateScreenItem client)
				(vPicture view: local1 loop: local2)
				(UpdateScreenItem vPicture)
				(if (and (== local1 35172) (== local2 2))
					(vLittleHand show:)
					(vBigHand show:)
				)
				(= cycles 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance playMovie of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(vPicture view: 35170 loop: 19 x: 0 y: 0)
		(UpdateScreenItem vPicture)
		(= temp0 228)
		(= temp1 42)
		(= temp2 ((VmdMovie new:) open: param1 client: gCurRoom yourself:))
		(temp2 showCursor: setPal: caller: gCurRoom)
		(temp2 put: temp0 temp1 4)
		(temp2 setWaitEvent: 7)
		(temp2 close:)
	)
)

