;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm017 0
)

(local
	local0
	local1
	local2
)

(instance rm017 of PQRoom
	(properties
		picture 17
	)

	(method (init)
		(locker init:)
		(cocaine init: hide:)
		(lockerInset init: hide:)
		(stallDoor init:)
		(bench init:)
		(stalls init:)
		(wrongLockers init:)
		(theWomansRoom init:)
		(gEgo
			view: (if (> gDay 1) 4 else 0)
			setStep: 3 2
			posn: 235 54
			init:
		)
		(lockList add: no1 no2 no3 roller1 roller2 roller3 lock)
		(no1 cel: (= local0 (Random 0 9)))
		(no2 cel: (= local1 (Random 0 9)))
		(no3 cel: (= local2 (Random 0 9)))
		(self
			setRegions: 891 ; station
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 59 89 122 64 153 77 93 102
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 96 103 157 78 177 84 116 110
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 122 110 189 82 220 96 160 125
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 163 127 232 94 250 101 188 133
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 193 134 260 100 300 110 238 145
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 215 81 132 56 26 98 247 178 266 160 244 149 308 111 242 76 263 61 213 37 246 0 234 0 191 39 257 62
					yourself:
				)
		)
		(super init:)
		(self setScript: enterScript)
		(pat cel: 1 init: setScript: patScript)
		(mySound play:)
		(lockerSound play:)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0002)
				(HandsOff)
				(self setScript: exitScript)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(lockList release: dispose:)
		(super dispose:)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 225 82 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 230 50 self)
				(mySound fade:)
			)
			(1
				(gCurRoom newRoom: 15)
			)
		)
	)
)

(instance patScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 90)
			)
			(1
				(HandsOff)
				(pat
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: PolyPath 225 82 self
					setCycle: Walk
					init:
				)
			)
			(2
				(pat setMotion: PChase gEgo 20 self)
			)
			(3
				(EgoDead 0 17 0) ; "Breaking and entering doesn't look good on a policeman's record, Sonny!"
			)
		)
	)
)

(instance lockerScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(gCast contains: no1)
				(== local0 3)
				(== local1 8)
				(== local2 6)
			)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 127 87 self)
			)
			(1
				(HandsOn)
				(lockList eachElementDo: #init)
			)
			(2
				(no1 cel: (= local0 (Random 0 9)))
				(no2 cel: (= local1 (Random 0 9)))
				(no3 cel: (= local2 (Random 0 9)))
				(lockList eachElementDo: #dispose)
				(lockerStingSound init: play:)
				(SetScore 174 10)
				(cocaine show:)
				(lockerInset show:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance locker of Feature
	(properties
		x 121
		y 112
		nsBottom 198
		nsRight 319
		description {locker door}
		onMeCheck 16384
		lookStr {That's Pat Morales' locker.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: lockerScript)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 17 1) ; "That would only attract attention, don't you think."
					)
					(else
						(Print 17 2) ; "That won't help you open the locker."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lockerInset of Prop
	(properties
		x 145
		y 149
		description {locker}
		view 156
		priority 15
		signal 16401
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (& (gEgo onControl: 0) $0080))
				(not (& (self signal:) $0080))
			)
			(cocaine hide:)
			(lockerInset hide:)
		)
		(if (and (not (& (gEgo onControl: 0) $0080)) (gCast contains: no1))
			(lockerScript dispose:)
			(lockList eachElementDo: #dispose)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cocaine hide:)
				(self hide:)
			)
			(4 ; Inventory
				(switch invItem
					(28 ; noteBook
						(Print 17 3) ; "You take notes on what you've found in Morales' locker."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance stallDoor of Prop
	(properties
		x 94
		y 112
		description {stall door}
		lookStr {If you've seen one stall, you've seen them all.}
		view 158
		loop 4
		priority 15
		signal 16401
	)
)

(instance cocaine of Prop
	(properties
		x 147
		y 149
		z 82
		description {cocaine}
		lookStr {Unbelievable! It looks like Morales has been stealing packets of cocaine.}
		view 156
		cel 4
		priority 15
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 17 4) ; "You'd better leave the cocaine here. If it were missing, Morales would get suspicious."
			)
			(4 ; Inventory
				(switch invItem
					(28 ; noteBook
						(Print 17 5) ; "You take notes on what you have found."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance theWomansRoom of Feature
	(properties
		onMeCheck 2048
		lookStr {This is the women's locker room. Hence, the lockers.}
	)
)

(instance bench of Feature
	(properties
		onMeCheck 1152
		lookStr {The benches provide a place to sit while getting dressed.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 17 6) ; "You need to get out of here quickly. You don't have time to lounge!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance stalls of Feature
	(properties
		x 69
		y 139
		onMeCheck 4
		lookStr {The toilet stalls lend a pleasant ambiance to the locker room.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 17 7) ; "It's bad enough that you're even in here!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance wrongLockers of Feature
	(properties
		x 162
		y 78
		onMeCheck 512
		lookStr {This is the women's locker room. Hence, the lockers.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 17 8) ; "That's not Morales' locker!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lock of Prop
	(properties
		x 81
		y 85
		description {dial lock}
		view 157
		priority 14
		signal 16401
	)
)

(instance no1 of Prop
	(properties
		x 66
		y 72
		description {number}
		view 157
		loop 2
		priority 15
		signal 16401
	)
)

(instance no2 of Prop
	(properties
		x 81
		y 72
		description {number}
		view 157
		loop 2
		priority 15
		signal 16401
	)
)

(instance no3 of Prop
	(properties
		x 96
		y 72
		description {number}
		view 157
		loop 2
		priority 15
		signal 16401
	)
)

(instance roller1 of Prop
	(properties
		x 59
		y 73
		description {flashlight}
		view 157
		loop 1
		priority 15
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setCycle: End)
				(if (== local0 10)
					(= local0 0)
				)
				(no1 cel: (++ local0) forceUpd:)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance roller2 of Prop
	(properties
		x 74
		y 73
		description {flashlight}
		view 157
		loop 1
		priority 15
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setCycle: End)
				(if (== local1 10)
					(= local1 0)
				)
				(no2 cel: (++ local1) forceUpd:)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance roller3 of Prop
	(properties
		x 89
		y 73
		description {flashlight}
		view 157
		loop 1
		priority 15
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setCycle: End)
				(if (== local2 10)
					(= local2 0)
				)
				(no3 cel: (++ local2) forceUpd:)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance pat of Actor
	(properties
		x 225
		y 48
		view 22
	)

	(method (doit)
		(if (or (== (pat cel:) 0) (== (pat cel:) 4))
			(stepSound number: (Random 312 316) play:)
		)
		(super doit:)
	)
)

(instance lockList of List
	(properties)
)

(instance mySound of Sound
	(properties
		number 172
		loop -1
	)
)

(instance lockerSound of Sound
	(properties
		number 170
		loop -1
	)
)

(instance lockerStingSound of Sound
	(properties
		number 171
	)
)

(instance stepSound of Sound
	(properties)
)

