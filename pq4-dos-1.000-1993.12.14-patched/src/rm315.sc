;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Array)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm315 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
)

(instance rm315 of Room
	(properties
		noun 10
		picture 315
	)

	(method (init)
		(= local10 (IntArray newWith: 4 315 320 321 -1))
		(gEgo x: 0 y: 0)
		(barFly
			view: 9315
			setLoop: 0
			cel: 0
			x: 120
			y: 118
			priority: 105
			signal: 20481
			init:
		)
		((= local0 (View new:)) view: 9320 y: -50 init:)
		(FrameOut)
		(local0 dispose:)
		(dancer setScript: dance init:)
		(straws init:)
		(cond
			((== gDay 4)
				(if (gPqFlags test: 96)
					(if (or (gPqFlags test: 93) (< global162 5))
						(self setScript: sEnter)
					else
						(stripper view: 333 noun: 3 init:)
						(if (gPqPointFlags test: 53)
							(= local3 1)
						)
						(self setScript: barbieEnter)
						(stripTell init: stripper 315 4 5)
					)
				else
					(stripper init:)
					(if (gPqPointFlags test: 52)
						(= local3 1)
					)
					(stripTell init: stripper 315 2 5)
					(self setScript: stripEnter)
					(cigs init:)
					(lighter init:)
				)
			)
			(
				(and
					(== gDay 5)
					(gEgo has: 22) ; folders
					((gInventory at: 22) state:) ; folders
					(not (gPqFlags test: 98))
				)
				(stripper view: 333 noun: 3 init:)
				(self setScript: barbieEnter)
			)
			(else
				(if (not (gEgo has: 28)) ; lighter
					(lighter init:)
				)
				(self setScript: sEnter)
			)
		)
		(super init: &rest)
		(audience init:)
		(bottle init:)
	)
)

(instance straws of Feature
	(properties
		noun 11
		nsLeft 66
		nsTop 129
		nsRight 77
		nsBottom 139
		sightAngle 40
		approachX 71
		approachY 134
		approachDist 0
		x 71
		y 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 49 153 49 109 59 108 57 94 85 94 79 113 79 120 90 117 104 119 101 125 98 154
					yourself:
				)
		)
		(super init:)
	)
)

(instance stripper of Prop
	(properties
		noun 1
		x 185
		y 106
		priority 130
		fixPriority 1
		view 317
		signal 4097
		cycleSpeed 4
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== gDay 5)
			(switch theVerb
				(2 ; Talk
					(++ global163)
					(switch global163
						(1
							(= temp0 9)
						)
						(2
							(= temp0 10)
						)
						(3
							(= temp0 11)
						)
						(4
							(= temp0 12)
						)
						(5
							(= temp0 13)
						)
						(6
							(= temp0 14)
						)
						(7
							(if (gPqFlags test: 97)
								(= temp0 15)
							else
								(= temp0 16)
							)
						)
						(else
							(= temp0 17)
						)
					)
					(self setScript: stripTalk 0 temp0)
				)
				(27 ; badge
					(gMessager say: noun theVerb 32) ; MISSING MESSAGE
				)
				(31 ; shoe
					(gMessager say: 3 31 35) ; "There is no need to show her the shoe again."
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(switch theVerb
				(27 ; badge
					(if (== noun 1)
						(gGame points: 2 52)
						(if local3
							(gMessager say: 3 theVerb 32 2) ; "There's no reason to show her your badge again."
						else
							(= local3 1)
							(barFly setScript: showBadge)
						)
					else
						(gGame points: 2 53)
						(if local3
							(gMessager say: noun theVerb 32) ; MISSING MESSAGE
						else
							(= local3 1)
							(barFly setScript: showBarbieBadge)
						)
					)
				)
				(31 ; shoe
					(cond
						((== noun 1)
							(if (gPqPointFlags test: 54)
								(gMessager say: 1 31 35) ; "There is no need to show her the shoe again."
							else
								(barFly setScript: showShoe)
							)
						)
						((gPqPointFlags test: 55)
							(gMessager say: 3 31 35) ; "There is no need to show her the shoe again."
						)
						(else
							(barFly setScript: showShoe)
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance cigs of View
	(properties
		x 222
		y 110
		priority 8
		view 315
		signal 16384
	)
)

(instance lighter of View
	(properties
		noun 6
		x 164
		y 117
		view 315
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 4)
				(cond
					(local4
						(barFly setScript: lightCig)
					)
					((not (gCast contains: stripper))
						(barFly setScript: takeLighter)
						(gMessager say: noun theVerb 34) ; "Never knowing when you might need to light a lady's cigarette,"
					)
					(else
						(gMessager say: noun theVerb 26) ; "This lighter belongs to the lady. Not you."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stripper view: 323 loop: 0 cel: 0)
				(= ticks (Random 300 500))
			)
			(1
				(if (stripper cel:)
					(self init:)
				else
					(stripper
						view: (if (== local9 5) 324 else 321)
						loop: 0
						cel: 0
						setCycle: End self
					)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(if (or register (== local9 5))
					(self cue:)
				else
					(stripper setCycle: Beg self)
				)
			)
			(4
				(if (stripper cel:)
					(self cue:)
				else
					(self init:)
				)
			)
			(5
				(= register 0)
				(stripper loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(stripper loop: 2 cel: 0 setCycle: End self)
			)
			(7
				(if (== local9 5)
					(stripper view: 317 loop: 0 cel: 5 setCycle: Beg self)
				else
					(++ local9)
					(= seconds (Random 30 60))
					(self init:)
				)
			)
			(8
				(self dispose:)
			)
		)
	)

	(method (init)
		(if argc
			(super init: &rest)
			(= seconds (Random 30 60))
		else
			(super init:)
		)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
		(if (and cycles (not (-- cycles)))
			(self cue:)
		)
		(if seconds
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= lastSeconds temp0)
				(= lastSeconds temp0)
				(if (not (-- seconds))
					(= register 1)
				)
			)
		)
		(if (and ticks (<= (-= ticks (Abs (- gGameTime lastTicks))) 0))
			(= ticks 0)
			(self cue:)
		)
		(= lastTicks gGameTime)
	)
)

(instance takeLighter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (barFly cel:))
					(barFly setCycle: End self)
					(-- state)
				else
					(barFly view: 9318 loop: 0 cel: 0 setCycle: CT 8 1 self)
				)
			)
			(1
				(lighter dispose:)
				(gEgo get: 28) ; lighter
				(barFly setCycle: Beg self)
			)
			(2
				(barFly view: 9316 loop: 1 cel: local1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lightCig of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 4 6 0 self) ; "Behaving as a gentleman, you pick up the lighter and"
			)
			(1
				(if (not (barFly cel:))
					(barFly setCycle: End self)
					(-- state)
				else
					(barFly view: 9318 loop: 0 cel: 0 setCycle: CT 8 1 self)
				)
			)
			(2
				(lighter dispose:)
				(gEgo get: 28) ; lighter
				(barFly setCycle: End self)
			)
			(3
				(barFly view: 9319 loop: 0 cel: 0 setCycle: End self)
				(= local4 0)
				(= local5 1)
			)
			(4
				(stripper view: 319 loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(= ticks 80)
			)
			(6
				(stripper setCycle: Beg self)
				(barFly loop: 1 cel: 0 setCycle: End self)
				(gMessager say: 1 2 22) ; "You're as sweet as you're good-looking."
			)
			(7)
			(8
				(barFly view: 9316 loop: 1 cel: local1)
				(stripper view: 323 loop: 0)
				(stripper cel: (stripper lastCel:) setCycle: Beg self)
			)
			(9
				(stripper view: 323 loop: 0 cel: 0 setScript: smoke)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance dancer of Prop
	(properties
		noun 8
		x 139
		y 88
		fixPriority 1
		signal 20481
	)
)

(instance barFly of Prop
	(properties)

	(method (init)
		(= actions gEgo)
		(= fixPriority 1)
		(super init:)
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)
)

(instance showShoe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== (stripper noun:) 3)
						(if (> global154 2)
							(gGame points: 2 55)
							(gPqFlags set: 93)
						)
					)
					(local3
						(gGame points: 3 54)
					)
				)
				(gGame handsOff:)
				(if (not (barFly cel:))
					(barFly setCycle: End self)
					(-- state)
				else
					(barFly view: 9323 loop: 0 cel: 0 setCycle: Fwd)
					(= ticks 60)
				)
			)
			(1
				(gMessager say: (stripper noun:) 2 7 0 self)
			)
			(2
				(self setScript: lookLeft self)
			)
			(3
				(barFly view: 9319 loop: 1)
				(barFly cel: (barFly lastCel:) setCycle: Beg self)
			)
			(4
				(if local3
					(if
						(if (== (stripper noun:) 3)
							(if (> global154 2)
								(gMessager say: (stripper noun:) 31 0 1 self)
							else
								(gMessager say: (stripper noun:) 31 0 1 self)
							)
						else
							(gMessager say: (stripper noun:) 31 0 1 self)
						)
					)
				else
					(gMessager say: (stripper noun:) 2 1 0 self)
				)
			)
			(5
				(barFly setCycle: End self)
				(if (and (== (stripper noun:) 3) local3)
					(self cue:)
				else
					(self setScript: lookRight self)
				)
			)
			(6)
			(7
				(barFly view: 9316 loop: 1 cel: local1)
				(if local3
					(self setScript: primp self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(8
				(gMessager say: (stripper noun:) 31 0 2 self)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance primp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(local5
						(gGame handsOn:)
						(self dispose:)
					)
					((== (= register (stripper noun:)) 1)
						(stripper view: 316 loop: 0 cel: 0 setCycle: End self)
					)
					(else
						(stripper view: 335 loop: 0 cel: 0 setCycle: End self)
					)
				)
			)
			(1
				(if (== register 1)
					(stripper loop: 1 cel: 0 setCycle: End self)
				else
					(= ticks 60)
				)
			)
			(2
				(stripper setCycle: Beg self)
			)
			(3
				(if (== register 1)
					(stripper loop: 0)
					(stripper cel: (stripper lastCel:) setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(4
				(if (== register 1)
					(stripper view: 317 loop: 0 cel: 0)
					(= cycles 1)
				else
					(stripper view: 332 loop: 0)
					(stripper cel: (stripper lastCel:) setCycle: Beg self)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance showBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (barFly cel:))
					(barFly setCycle: End self)
					(-- state)
				else
					(barFly view: 9317 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(1
				(barFly view: 9324 cel: 0 setCycle: End self)
			)
			(2
				(if (gPqFlags test: 177)
					(self cue:)
				else
					(gPqFlags set: 177)
					(gMessager say: 1 2 18 0 self) ; "Hello, I'm Detective Carey, LAPD, Homicide. I'm investigating a series of murders, I was wondering if you'd talk to me?"
				)
			)
			(3
				(self setScript: lookLeft self)
			)
			(4
				(gMessager say: 1 27 0 0 self) ; "Ummm... so you're a real cop. Tell me, handsome, is everything you're packing real?"
			)
			(5
				(barFly setCycle: Beg self)
			)
			(6
				(barFly view: 9317 loop: 0)
				(barFly cel: (barFly lastCel:) setCycle: Beg self)
			)
			(7
				(barFly view: 9316 loop: 1 cel: local1)
				(client setScript: lookRight)
				(gGame handsOn:)
			)
		)
	)
)

(instance showBarbieBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global163 0)
				(gGame handsOff:)
				(if (not (barFly cel:))
					(barFly setCycle: End self)
					(-- state)
				else
					(barFly view: 9317 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(1
				(barFly view: 9324 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 3 27 33 0 self) ; "Hello, I'm Detective John Carey, LAPD, Homicide. I was wondering if I could ask you a few questions."
			)
			(3
				(stripper view: 336 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(stripper loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(stripper setCycle: Beg self)
			)
			(6
				(gMessager say: 3 27 0 0 self) ; "Absolutely not, darlin'... I don't talk to police, officially that is..."
			)
			(7
				(barFly setCycle: Beg self)
				(stripper loop: 0)
				(stripper cel: (stripper lastCel:) setCycle: Beg self)
			)
			(8)
			(9
				(barFly view: 9317 loop: 0)
				(barFly cel: (barFly lastCel:) setCycle: Beg self)
			)
			(10
				(barFly view: 9316 loop: 1 cel: local1)
				(stripper view: 332 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(== (stripper view:) 317)
						(== (stripper view:) 323)
						(== (stripper view:) 332)
					)
					(= local6 1)
					(= local7 (smoke ticks:))
					(= local8 (smoke seconds:))
					(smoke seconds: 0 lastTicks: 0 ticks: 0)
					(stripper setCycle: End self)
				else
					(= local6 0)
					(= ticks 120)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance lookRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(or
							(== (stripper view:) 317)
							(== (stripper view:) 323)
							(== (stripper view:) 332)
						)
						local6
					)
					(stripper setCycle: Beg self)
					(= register 1)
				else
					(= ticks 120)
				)
			)
			(1
				(if register
					(= register 0)
					(smoke lastTicks: gGameTime ticks: local7 seconds: local8)
				)
				(self dispose:)
			)
		)
	)
)

(instance jukeBox of Script
	(properties)

	(method (init)
		(gTheDoits add: self)
		(= lastTicks gGameTime)
		(= register (Random 0 2))
		(= state (- start 1))
		(self cue:)
	)

	(method (dispose)
		(gGlobalSound0 client: 0)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (doit)
		(super doit:)
		(if (and (not state) (== (gGlobalSound0 prevSignal:) 10))
			(gGlobalSound0 prevSignal: 0)
			(if (> (++ local11) 2)
				(= local11 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(dancer cycleSpeed: 5)
					)
					(1
						(dancer cycleSpeed: 4)
					)
					(2
						(dancer cycleSpeed: 6)
					)
				)
				(gGlobalSound0 number: (local10 at: register) loop: -1 play:)
			)
			(1
				(gGlobalSound0 fade: 0 10 10 1 self)
			)
			(2
				(if (== (local10 at: (++ register)) -1)
					(= register 0)
				)
				(self init:)
			)
		)
	)
)

(instance dance of Script
	(properties)

	(method (init param1 param2 param3)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			((= client param1) script: self)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
				)
			)
		)
		(if argc
			(jukeBox init:)
			(= state (- (Random 0 25) 1))
		else
			(= state (- start 1))
		)
		(self cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(dancer view: 325 loop: 0 cel: 0 priority: 0 setCycle: End self)
			)
			(1
				1
				(dancer view: 325 loop: 1 cel: 0 priority: 0 setCycle: End self)
			)
			(2
				2
				(dancer view: 326 loop: 0 cel: 0 priority: 0 setCycle: End self)
			)
			(3
				3
				(dancer
					view: 326
					loop: 1
					cel: 0
					priority: 50
					setCycle: End self
				)
			)
			(4
				4
				(dancer
					view: 326
					loop: 2
					cel: 0
					priority: 50
					setCycle: End self
				)
			)
			(5
				5
				(dancer view: 326 loop: 3 cel: 0 priority: 0 setCycle: End self)
			)
			(6
				6
				(dancer view: 327 loop: 0 cel: 0 priority: 0 setCycle: End self)
			)
			(7
				7
				(dancer
					view: 327
					loop: 1
					cel: 0
					priority: 50
					setCycle: End self
				)
			)
			(8
				8
				(dancer
					view: 327
					loop: 2
					cel: 0
					priority: 50
					setCycle: End self
				)
			)
			(9
				9
				(dancer view: 327 loop: 3 cel: 0 priority: 0 setCycle: End self)
			)
			(10
				10
				(dancer view: 328 loop: 0 cel: 0 priority: 0 setCycle: End self)
			)
			(11
				11
				(dancer view: 328 loop: 1 cel: 0 priority: 0 setCycle: End self)
			)
			(12
				12
				(dancer view: 328 loop: 2 cel: 0 priority: 0 setCycle: End self)
			)
			(13
				13
				(dancer view: 328 loop: 3 cel: 0 priority: 0 setCycle: End self)
			)
			(14
				(dancer view: 329 loop: 0 cel: 0 priority: 0 setCycle: End self)
			)
			(15
				15
				(dancer view: 329 loop: 1 cel: 0 priority: 0 setCycle: End self)
			)
			(16
				16
				(dancer view: 329 loop: 2 cel: 0 priority: 0 setCycle: End self)
			)
			(17
				17
				(dancer view: 329 loop: 3 cel: 0 priority: 0 setCycle: End self)
			)
			(18
				18
				(dancer view: 330 loop: 0 cel: 0 priority: 0 setCycle: End self)
			)
			(19
				19
				(dancer view: 330 loop: 1 cel: 0 priority: 0 setCycle: End self)
			)
			(20
				20
				(dancer view: 330 loop: 2 cel: 0 priority: 0 setCycle: End self)
			)
			(21
				21
				(dancer view: 330 loop: 3 cel: 0 priority: 0 setCycle: End self)
			)
			(22
				22
				(dancer view: 331 loop: 0 cel: 0 priority: 0 setCycle: End self)
			)
			(23
				23
				(dancer
					view: 331
					loop: 1
					cel: 0
					priority: 50
					setCycle: End self
				)
			)
			(24
				24
				(dancer view: 331 loop: 2 cel: 0 priority: 0 setCycle: End self)
			)
			(25
				25
				(dancer view: 331 loop: 3 cel: 0 priority: 0 setCycle: End self)
			)
			(26
				(self init:)
			)
		)
	)
)

(instance stripTell of Teller
	(properties)

	(method (showCases)
		(super showCases: 5 (gPqPointFlags test: 54))
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(cond
				((== sayNoun 4)
					(if local3
						(switch global154
							(0
								(++ global154)
								(gMessager say: 3 2 8) ; "Well, how about if we talk off the record? Just a little talk between friends?"
							)
							(1
								(++ global154)
								(gMessager say: 3 2 28) ; "Why don't we start with an introduction. As I told you, my name is John Carey... and I bet you're Barbie Cann."
							)
							(2
								(++ global154)
								(= sayNoun 5)
								(gMessager say: 3 2 29) ; "Well, the subject's a bit gruesome... I'd like to ask you some questions about a series of murders I'm investigating..."
							)
							(else
								(= sayNoun 5)
								(super doVerb: theVerb)
							)
						)
					else
						(super doVerb: theVerb)
					)
				)
				((== sayNoun 5)
					(super doVerb: theVerb)
				)
				((not (gPqFlags test: 177))
					(gPqFlags set: 177)
					(gMessager say: 1 2 18) ; "Hello, I'm Detective Carey, LAPD, Homicide. I'm investigating a series of murders, I was wondering if you'd talk to me?"
				)
				((gPqFlags test: 96)
					(switch global163
						(0
							(++ global163)
							(gMessager say: 1 2 23) ; "I appreciate you taking the time to answer my questions, Electra. It's citizens like you who help us cops do our jobs."
						)
						(1
							(++ global163)
							(gMessager say: 1 2 24) ; "If you can think of anything else, I can be reached at Parker Center, Homicide, Robbery. Just ask for Detective Carey."
						)
						(else
							(gMessager say: 1 2 25) ; "Handsome, you should relax a little bit... you're awfully tense."
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (sayMessage)
		(if (== iconValue 10)
			(if (not (gPqFlags test: 107))
				(gPqFlags set: 108)
			)
			(gPqFlags set: 106)
		)
		(if (== iconValue 5)
			(= global162 1)
			(gPqFlags set: 96)
		)
		(barFly setScript: stripTalk 0 iconValue)
		(return 1)
	)
)

(instance stripTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(= cycles 1)
			)
			(2
				(if (not (barFly cel:))
					(barFly setCycle: End self)
					(-- state)
				else
					(barFly view: 9323 loop: 0 cel: 0 setCycle: Fwd)
					(self setScript: lookLeft self)
				)
			)
			(3
				(cond
					((== gDay 5)
						(self cue:)
					)
					((== (stripTell sayNoun:) 5)
						(gMessager say: 4 2 register 0 self)
					)
					(else
						(gMessager say: (stripTell sayNoun:) 2 register 0 self)
					)
				)
			)
			(4
				(if (or local3 (== (stripper noun:) 3))
					(if (== gDay 5)
						(gMessager say: 4 2 register 0 self)
					else
						(gMessager say: (stripTell sayNoun:) 5 register 0 self)
					)
				else
					(gMessager say: 1 2 1 0 self) ; "You're sure nosey for someone without any kind of official identification, fella."
				)
			)
			(5
				(barFly view: 9316 loop: 1 cel: local1 setCycle: 0)
				(cond
					((== register 5)
						(cond
							(local4
								(gGame handsOn:)
								(self dispose:)
							)
							((not local5)
								(= local4 1)
								(self setScript: lookRight self)
							)
							(else
								(client setScript: lookRight)
								(gGame handsOn:)
							)
						)
					)
					((and (== gDay 5) (== register 17))
						(gPqFlags set: 98)
						(barbieEnter cue:)
					)
					(else
						(client setScript: lookRight)
						(gGame handsOn:)
					)
				)
			)
			(6
				(stripper view: 318 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(stripper loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(stripper loop: 2 cel: 0 setCycle: End self)
			)
			(9
				(gMessager say: 1 2 6 0 self) ; "Got a light, handsome?"
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance byeBye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (stripper cel:))
					(stripper setCycle: End self)
					(-- state)
				else
					(stripper view: 339 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(1
				(= ticks 45)
			)
			(2
				(stripper setCycle: Beg)
			)
		)
	)
)

(instance barbieEnter of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gWalkHandler addToFront: self)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(self cue:)
			)
			(1
				1
				(barFly setCycle: End self)
			)
			(2
				2
				(barFly
					view: 9320
					setLoop: 0
					cel: 0
					x: 164
					y: 114
					setCycle: CT 7 1
				)
				(stripper setCycle: End self)
			)
			(3
				3
				(stripper loop: 1 cel: 0 setCycle: End self)
				(barFly priority: 130 setCycle: End self)
			)
			(4 4)
			(5
				5
				(barFly view: 9316 setLoop: 1)
				(barFly
					cel: (= local1 (barFly lastCel:))
					x: 122
					y: 118
					priority: 130
					init:
				)
				(= local2 1)
				(stripper loop: 2 cel: 0 setCycle: End self)
				(gMessager say: 3 2 19) ; "Why hello there Darlin'..."
			)
			(6
				6
				(stripper view: 332 loop: 0)
				(stripper cel: (stripper lastCel:) setCycle: Beg self)
			)
			(7
				7
				(gGame handsOn:)
			)
			(8
				8
				(gGame handsOff:)
				(if (not (barFly cel:))
					(barFly setCycle: End self)
					(-- state)
				else
					(stripper setScript: byeBye)
					(barFly view: 9326 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(9
				9
				(barFly
					view: 9328
					priority: 105
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(10
				10
				(gCurRoom newRoom: 310)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((& (event type:) evMOVE)
				(if (== state 7)
					(self cue:)
				)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(not (barFly cycler:))
					(not (event modifiers:))
				)
				(if (barFly onMe: event)
					(event claimed: 0)
					(return)
				)
				(cond
					((and (not (barFly cel:)) (> (event x:) (barFly x:)))
						(barFly setCycle: End)
					)
					((and (<= (event x:) (barFly x:)) (barFly cel:))
						(barFly setCycle: Beg)
					)
				)
				(event claimed: 0)
				(return)
			)
		)
		(event claimed: 0)
	)
)

(instance sEnter of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gWalkHandler addToFront: self)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(barFly setCycle: End self)
			)
			(1
				1
				(barFly
					view: 9320
					setLoop: 0
					cel: 0
					x: 164
					y: 114
					setCycle: CT 7 1 self
				)
			)
			(2
				2
				(barFly priority: 130 setCycle: End self)
			)
			(3
				3
				(barFly view: 9316 setLoop: 1)
				(barFly
					cel: (= local1 (barFly lastCel:))
					x: 122
					y: 118
					priority: 130
					init:
				)
				(gGame handsOn:)
			)
			(4
				4
				(gGame handsOff:)
				(if (not (barFly cel:))
					(barFly setCycle: End self)
					(-- state)
				else
					(barFly view: 9326 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(5
				5
				(barFly
					view: 9328
					priority: 105
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(6
				6
				(gCurRoom newRoom: 310)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((& (event type:) evMOVE)
				(if (== state 3)
					(self cue:)
				)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(not (barFly cycler:))
					(not (event modifiers:))
				)
				(if (barFly onMe: event)
					(event claimed: 0)
					(return)
				)
				(cond
					((and (not (barFly cel:)) (> (event x:) (barFly x:)))
						(barFly setCycle: End)
					)
					((and (<= (event x:) (barFly x:)) (barFly cel:))
						(barFly setCycle: Beg)
					)
				)
				(event claimed: 0)
				(return)
			)
		)
		(event claimed: 0)
	)
)

(instance stripEnter of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gWalkHandler addToFront: self)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(self cue:)
			)
			(1
				1
				(barFly setCycle: End self)
			)
			(2
				2
				(barFly
					view: 9320
					setLoop: 0
					cel: 0
					x: 164
					y: 114
					setCycle: CT 7 1 self
				)
			)
			(3
				3
				(stripper setCycle: End self)
				(barFly priority: 130 setCycle: End self)
			)
			(4 4)
			(5
				5
				(barFly view: 9316 setLoop: 1)
				(barFly
					cel: (= local1 (barFly lastCel:))
					x: 122
					y: 118
					priority: 130
					init:
				)
				(= local2 1)
				(stripper loop: 1 cel: 0 setCycle: End self)
			)
			(6
				6
				(stripper setCycle: Beg self)
				(if (gPqPointFlags test: 52)
					(gMessager say: 1 2 30) ; "Hello..."
				else
					(gMessager say: 1 2 19) ; "Hello there handsome..."
				)
			)
			(7
				7
				(stripper loop: 0)
				(stripper cel: (stripper lastCel:) setCycle: Beg)
				(gGame handsOn:)
			)
			(8
				8
				(gGame handsOff:)
				(if (not (barFly cel:))
					(barFly setCycle: End self)
					(-- state)
				else
					(barFly view: 9326 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(9
				9
				(barFly
					view: 9328
					priority: 80
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(10
				10
				(gCurRoom newRoom: 310)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((& (event type:) evMOVE)
				(if (== state 7)
					(self cue:)
				)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(not (barFly cycler:))
					(not (event modifiers:))
				)
				(if (barFly onMe: event)
					(event claimed: 0)
					(return)
				)
				(cond
					((and (not (barFly cel:)) (> (event x:) (barFly x:)))
						(barFly setCycle: End)
					)
					((and (<= (event x:) (barFly x:)) (barFly cel:))
						(barFly setCycle: Beg)
					)
				)
				(event claimed: 0)
				(return)
			)
		)
		(event claimed: 0)
	)
)

(instance bottle of Feature
	(properties
		noun 7
		x 19
		y 97
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 24 75 29 74 32 97 38 105 40 110 39 152 16 152 14 148 13 103 19 97 21 95 22 79
					yourself:
				)
		)
	)
)

(instance audience of Feature
	(properties
		noun 9
		x 19
		y 97
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 109 80 112 80 115 81 115 86 118 87 119 91 119 95 102 95 102 91 104 88 107 87
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 148 81 148 88 154 94 152 101 154 107 134 110 136 98 136 93 141 91 144 89 141 88 142 85
					yourself:
				)
		)
	)
)

