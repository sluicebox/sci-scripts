;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm016 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm016 of PQRoom
	(properties
		picture 16
	)

	(method (init)
		(LoadMany rsVIEW 0 4 150 155 156 157 158 159)
		(super init:)
		(stallDoor init:)
		(toiletPaper init:)
		(toilet init:)
		(locker init:)
		(otherLocker init:)
		(bench init:)
		(theStalls init:)
		(theRoom init:)
		(self
			setRegions: 891 ; station
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 173 58 96 81 55 60 109 44 97 36 0 70 0 0 319 0 319 189 0 189 0 128 50 168 176 131 233 159 247 150 225 143 212 144 192 134 287 100
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 250 92 214 103 149 80 189 67
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 205 103 190 108 130 86 141 83
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 184 112 145 125 88 99 123 89
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 141 128 122 134 65 103 80 99
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 109 134 65 147 16 111 59 104
					yourself:
				)
		)
		(if (> gDay 1)
			(gEgo view: 4)
		else
			(gEgo view: 0)
		)
		(stickInset init: hide:)
		(flashInset init: hide:)
		(noteInset init: hide:)
		(lockerInset init: hide:)
		(if
			(and
				(== gDay 6)
				(not
					(or
						(== ((gInventory at: 12) owner:) 0) ; toiletPaper
						(== ((gInventory at: 12) owner:) 17) ; toiletPaper
						(gEgo has: 12) ; toiletPaper
					)
				)
			)
			(day6TP init:)
		)
		(switch gPrevRoomNum
			(15
				(HandsOff)
				(gEgo setStep: 3 2 posn: 76 47 init:)
				(self setScript: enterScript)
			)
			(else
				(gEgo setStep: 3 2 posn: 73 77 init:)
			)
		)
		(lockList add: no1 no2 no3 roller1 roller2 roller3 lock)
		(no1 cel: (= local1 (Random 0 9)))
		(no2 cel: (= local2 (Random 0 9)))
		(no3 cel: (= local3 (Random 0 9)))
		(lockerRmSound init: play:)
		(cond
			((== ((gInventory at: 12) owner:) 0) ; toiletPaper
				(Print 16 0) ; "Looks like the janitor fixed the toilet."
			)
			((== global109 1)
				(jSound play:)
				(janitor setScript: janScript init:)
			)
			((== ((gInventory at: 12) owner:) 17) ; toiletPaper
				(overFlow init: play:)
				(toilet loop: 3 posn: 231 149 setCycle: Fwd)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(
				(and
					(not (& (= temp1 (gEgo onControl: 0)) $0100))
					(not (& (lockerInset signal:) $0080))
				)
				(lockerInset hide:)
				(sFX number: 906 play:)
				(stickInset hide:)
				(flashInset hide:)
				(noteInset hide:)
				(if (== (gCurRoom script:) lockerScript)
					(lockerScript dispose:)
				)
			)
			((and (not (& temp1 $0100)) (gCast contains: no1))
				(if (== (gCurRoom script:) lockerScript)
					(lockerScript dispose:)
				)
				(lockList eachElementDo: #dispose)
			)
			(script 0)
			((& temp1 $0002)
				(self setScript: exitScript)
			)
			((& temp1 $0400)
				(HandsOff)
				(cond
					((== ((gInventory at: 12) owner:) 0) ; toiletPaper
						(self setScript: stallScript)
					)
					((or (== ((gInventory at: 12) owner:) 17) (== global109 1)) ; toiletPaper
						(self setScript: dontGoIn)
					)
					(else
						(self setScript: stallScript)
					)
				)
			)
			((& temp1 $0200)
				(HandsOff)
				(self setScript: stall2Script)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(lockList release: dispose:)
		(super dispose:)
	)
)

(instance getPaper of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(or
						(& (= temp0 (gEgo onControl: 0)) $0001)
						(& temp0 $0800)
						(& temp0 $0008)
						(& temp0 $0010)
						(& temp0 $0100)
						(& temp0 $0080)
					)
					(gEgo setMotion: PolyPath 195 124 self)
				else
					(gEgo setMotion: PolyPath 228 154 self)
					(+= state 2)
				)
			)
			(1
				(stallDoor setCycle: End self)
				(sFX number: 161 play:)
			)
			(2
				(gEgo setMotion: PolyPath 228 154 self)
			)
			(3
				(if (!= (stallDoor cel:) 0)
					(stallDoor setCycle: Beg)
					(sFX number: 161 play:)
				)
				(= local0 (gEgo view:))
				(gEgo
					normal: 0
					view: 159
					loop: 0
					posn: (gEgo x:) (- (gEgo y:) 5)
					cel: 0
					setCycle: End self
				)
			)
			(4
				(day6TP dispose:)
				(= cycles 1)
			)
			(5
				(gEgo
					normal: 1
					view: local0
					loop: 4
					x: (- (gEgo x:) 3) (+ (gEgo y:) 5)
					setCycle: Walk
				)
				(= cycles 2)
			)
			(6
				(Print 16 1 #at 40 20) ; "You unroll all of the two ply toilet paper creating a big wad."
				(gEgo get: 12) ; toiletPaper
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance stuffPaper of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(not
						(or
							(& (= temp0 (gEgo onControl: 0)) $1000)
							(& temp0 $0200)
							(& temp0 $2000)
						)
					)
					(gEgo setMotion: PolyPath 195 124 self)
				else
					(+= state 3)
					(gEgo setMotion: PolyPath 237 153 self)
				)
			)
			(1
				(stallDoor setCycle: End self)
				(sFX number: 161 play:)
			)
			(2
				(gEgo setMotion: PolyPath 237 153 self)
			)
			(3
				(stallDoor setCycle: Beg self)
				(sFX number: 161 play:)
			)
			(4
				(stallDoor stopUpd:)
				(= local0 (gEgo view:))
				(gEgo normal: 0 view: 159 loop: 1 cel: 0 setCycle: End self)
				(Print 16 2 #dispose #at 40 20) ; "You toss the wad of paper into the toilet and flush it."
			)
			(5
				(gEgo loop: 2 cel: 0 setCycle: CT 5 1 self)
			)
			(6
				(gEgo loop: 2 setCycle: End self)
				(flushSound play:)
			)
			(7
				(gEgo
					normal: 1
					view: local0
					loop: 7
					setCycle: Walk
					x: (- (gEgo x:) 5)
				)
				(gEgo put: 12 17) ; toiletPaper
				(SetScore 172 5)
				(= cycles 2)
			)
			(8
				(stallDoor setCycle: End self)
				(sFX number: 161 play:)
			)
			(9
				(stallDoor stopUpd:)
				(gEgo setMotion: PolyPath 195 124 self)
				(Print 16 3 #dispose #at 40 20) ; "The toilet complains loudly and starts to overflow."
			)
			(10
				(stallDoor setCycle: Beg self)
				(sFX number: 161 play:)
			)
			(11
				(stallDoor stopUpd:)
				(toilet setPri: 13 setCycle: End self)
				(overFlow loop: -1 play:)
			)
			(12
				(toilet loop: 3 posn: 231 149 setCycle: Fwd)
				(= cycles 30)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(client setScript: 0)
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
				(== local1 7)
				(== local2 7)
				(== local3 6)
			)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& (gEgo onControl: 0) $1000)
					(stallDoor setCycle: End self)
					(sFX number: 161 play:)
				else
					(gEgo setMotion: PolyPath 119 112 self)
					(+= state 2)
				)
			)
			(1
				(gEgo setMotion: PolyPath 195 124 self)
			)
			(2
				(stallDoor setCycle: Beg self)
				(sFX number: 161 play:)
			)
			(3
				(stallDoor stopUpd:)
				(gEgo setMotion: PolyPath 119 112 self)
			)
			(4
				(if (not (IsFlag 220))
					(SetFlag 220)
					(Print 16 4) ; "Now, what was my combination? Oh yeah, I wrote it down on the inside cover of my Police Manual."
				)
				(HandsOn)
				(lockList eachElementDo: #init)
			)
			(5
				(no1 cel: (= local1 (Random 0 9)))
				(no2 cel: (= local2 (Random 0 9)))
				(no3 cel: (= local3 (Random 0 9)))
				(lockList eachElementDo: #dispose)
				(if (== ((gInventory at: 16) owner:) 16) ; nightStick
					(stickInset show:)
				)
				(if (== ((gInventory at: 4) owner:) 16) ; flashlight
					(flashInset show:)
				)
				(if (== ((gInventory at: 28) owner:) 16) ; noteBook
					(noteInset show:)
				)
				(lockerInset show:)
				(= cycles 1)
			)
			(6
				(SetScore 97 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 195 124 self)
			)
			(1
				(Face gEgo toilet self)
			)
			(2
				(sFX number: 161 play:)
				(stallDoor setCycle: End self)
			)
			(3
				(gEgo setMotion: PolyPath 228 159 self)
			)
			(4
				(stallDoor setCycle: Beg self)
			)
			(5
				(sFX number: 161 play:)
				(stallDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stall2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo heading: 290 setMotion: 0)
				(Face gEgo stallDoor self)
			)
			(1
				(stallDoor setCycle: End self)
				(sFX number: 161 play:)
			)
			(2
				(gEgo setMotion: PolyPath 195 124 self)
			)
			(3
				(stallDoor setCycle: Beg self)
			)
			(4
				(sFX number: 161 play:)
				(stallDoor stopUpd:)
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
				(HandsOff)
				(gEgo setMotion: PolyPath 80 48 self)
				(lockerRmSound fade:)
				(overFlow fade:)
			)
			(1
				(gCurRoom newRoom: 15)
			)
		)
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
				(gEgo setMotion: PolyPath 73 77 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dontGoIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: janitor)
					(Print 16 5) ; "The janitor looks a little busy at the moment. Better leave him alone and get on with your sleuthing?"
				else
					(Print 16 6) ; "I wouldn't go in there with that toilet running."
				)
				(gEgo setMotion: PolyPath 181 132 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance janScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(janitor setCycle: CT 10 1 self)
			)
			(1
				(sFX number: 165 play:)
				(janitor setCycle: CT 4 -1 self)
				(= state -1)
			)
		)
	)
)

(instance talkJanitor of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Say janitor 16 7) ; "Geez! Someone had some serious paper work to do in here. They musta' used an entire roll."
				(= seconds 9)
			)
			(1
				(= save1 1)
				(Say janitor 16 8) ; "Bet it was that Officer Walls again."
				(= seconds 5)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance flushScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(flushSound play:)
				(= cycles 3)
			)
			(1
				(Print 16 9) ; "Flush. Flush. The spiraling water IS spellbinding, isn't it?"
				(= cycles 1)
			)
			(2
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
		onMeCheck 2048
		lookStr {That's your locker.}
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
						(Print 16 10) ; "This is the men's locker room - not target practice."
					)
					(else
						(Print 16 11) ; "Try your combination."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance toiletPaper of Feature
	(properties
		nsBottom 198
		nsRight 319
		description {toilet paper.}
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((== gDay 1)
						(Print 16 12) ; "Oops. The t.p. dispenser is empty. Good thing you noticed it while you're still standing."
					)
					((or (== gDay 2) (== gDay 3))
						(Print 16 13) ; "Someone's used up all the toilet paper. You'll have to wait for the janitor to fill the dispenser."
					)
					((== gDay 4)
						(Print 16 14) ; "The dispenser is empty."
					)
					((== gDay 5)
						(Print 16 15) ; "The janitor hasn't filled the dispenser with paper yet."
					)
					(
						(and
							(== gDay 6)
							(not
								(or
									(== ((gInventory at: 12) owner:) 0) ; toiletPaper
									(== ((gInventory at: 12) owner:) 17) ; toiletPaper
									(gEgo has: 12) ; toiletPaper
								)
							)
						)
						(Print 16 16) ; "The "Roll King"dispenser is filled with a fresh new roll of standard issue, two-ply "Timbersoft" toilet paper."
					)
					(
						(or
							(== gDay 7)
							(== ((gInventory at: 12) owner:) gEgo) ; toiletPaper
						)
						(Print 16 17) ; "The roll is empty. You emptied it, remember?"
					)
					(else
						(Print 16 18) ; "It seems the last person used all the toilet paper."
					)
				)
			)
			(3 ; Do
				(cond
					((== ((gInventory at: 12) owner:) gEgo) ; toiletPaper
						(Print 16 17) ; "The roll is empty. You emptied it, remember?"
					)
					((== ((gInventory at: 12) owner:) 17) ; toiletPaper
						(Print 16 6) ; "I wouldn't go in there with that toilet running."
					)
					((== gDay 1)
						(Print 16 19) ; "Oops. The t.p. dispenser is empty. Good thing you notice it while you're still standing."
					)
					((== gDay 2)
						(Print 16 20) ; "The toilet paper is all gone. You begin to wonder if the janitor is doing his job."
					)
					((== gDay 3)
						(Print 16 21) ; "They can put men on the moon... but they can't make a dispenser that won't run out of paper!"
					)
					((== gDay 4)
						(Print 16 22) ; "Damn! No paper!"
					)
					((== gDay 5)
						(Print 16 23) ; "No time to sit now. Besides, the toilet paper is all gone. You leave the janitor a note to fill the toilet paper dispenser."
					)
					(
						(and
							(== gDay 6)
							(not
								(or
									(== ((gInventory at: 12) owner:) 0) ; toiletPaper
									(== ((gInventory at: 12) owner:) 17) ; toiletPaper
									(gEgo has: 12) ; toiletPaper
								)
							)
						)
						(HandsOff)
						(gCurRoom setScript: getPaper)
					)
					(else
						(Print 16 24) ; "No paper! You wish the chief would stop using this stall."
					)
				)
			)
			(4 ; Inventory
				(Print 16 25) ; "I would have thought you would know the use for toilet paper."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance toilet of Prop
	(properties
		x 243
		y 149
		description {toilet.}
		lookStr {Just your regular ol' run-of-the-mill john.}
		view 158
		signal 16384
		cycleSpeed 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (& (gEgo onControl: 0) $1000)
					(self setScript: flushScript)
				else
					(Print 16 26) ; "You can't do that from there..."
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; toiletPaper
						(HandsOff)
						(gCurRoom setScript: stuffPaper)
					)
					(else
						(Print 16 27) ; "They have a name for people who are obsessed with toilets, you know."
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
		x 177
		y 112
		description {stall door}
		lookStr {The toilet stalls lend a pleasant ambiance to the locker room.}
		view 158
		loop 1
		priority 11
		signal 16401
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(3 ; Do
				(if (and (IsFlag 172) (not (== ((gInventory at: 12) owner:) 0))) ; toiletPaper
					(Print 16 6) ; "I wouldn't go in there with that toilet running."
				else
					(HandsOff)
					(if
						(or
							(& (= temp0 (gEgo onControl: 0)) $1000)
							(& temp0 $2000)
						)
						(gCurRoom setScript: stall2Script)
					else
						(gCurRoom setScript: stallScript)
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
		x 150
		y 166
		description {locker}
		lookStr {You store some of your equipment in this locker.}
		view 156
		priority 14
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self hide:)
				(stickInset hide:)
				(flashInset hide:)
				(noteInset hide:)
				(sFX number: 906 play:)
			)
			(4 ; Inventory
				(switch invItem
					(16 ; nightStick
						(gEgo put: 16 16) ; nightStick
						(stickInset show:)
					)
					(4 ; flashlight
						(gEgo put: 4 16) ; flashlight
						(flashInset show:)
					)
					(28 ; noteBook
						(gEgo put: 28 16) ; noteBook
						(noteInset show:)
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

	(method (show)
		(super show:)
		(sFX number: 905 play:)
	)
)

(instance stickInset of Prop
	(properties
		x 165
		y 166
		description {nightstick}
		lookStr {This is your PR\\24 (nightstick).}
		view 156
		cel 3
		priority 15
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 16 28) ; "You remove your nightstick."
				(gEgo get: 16) ; nightStick
				(SetScore 99 1)
				(self hide:)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance noteInset of Prop
	(properties
		x 184
		y 76
		description {ticket book}
		lookStr {This is your notebook.}
		view 156
		cel 2
		priority 15
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 16 29) ; "You remove your notebook."
				(gEgo get: 28) ; noteBook
				(SetScore 100 1)
				(self hide:)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance flashInset of Prop
	(properties
		x 116
		y 76
		description {flashlight}
		lookStr {This is your flashlight.}
		view 156
		cel 1
		priority 15
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 16 30) ; "You remove your flashlight."
				(gEgo get: 4) ; flashlight
				(SetScore 98 1)
				(self hide:)
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
		description {flashlight}
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
		description {flashlight}
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
		description {flashlight}
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
				(if (== local1 10)
					(= local1 0)
				)
				(no1 cel: (++ local1) forceUpd:)
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
				(if (== local2 10)
					(= local2 0)
				)
				(no2 cel: (++ local2) forceUpd:)
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
				(if (== local3 10)
					(= local3 0)
				)
				(no3 cel: (++ local3) forceUpd:)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lockList of List
	(properties)
)

(instance janitor of Prop
	(properties
		x 234
		y 154
		description {janitor}
		lookStr { Looks as if the janitor is having trouble with your handy work. That should keep him busy for quite a while.}
		view 155
		priority 13
		signal 16
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(HandsOff)
				(gCurRoom setScript: talkJanitor)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance otherLocker of Feature
	(properties
		x 121
		y 112
		description {locker door}
		onMeCheck 8
		lookStr {This is the men's locker room. Hence, the lockers.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 16 31) ; "That locker belongs to somebody else, Bonds!"
			)
			(4 ; Inventory
				(Print 16 31) ; "That locker belongs to somebody else, Bonds!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance bench of Feature
	(properties
		x 121
		y 112
		onMeCheck 272
		lookStr {The benches provide a place to sit while you're getting dressed.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 16 32) ; "You don't have time to sit down."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance theStalls of Feature
	(properties
		sightAngle 360
		onMeCheck 30336
		lookStr {The toilet stalls lend a pleasant ambiance to the locker room.}
	)
)

(instance theRoom of Feature
	(properties
		sightAngle 360
		lookStr {You're standing in the men's locker room.}
	)
)

(instance day6TP of View
	(properties
		x 236
		y 124
		sightAngle 360
		view 159
		loop 3
		priority 11
		signal 16
	)

	(method (doVerb theVerb invItem)
		(toiletPaper doVerb: theVerb invItem)
	)
)

(instance lockerRmSound of Sound
	(properties
		flags 1
		number 160
		loop -1
	)
)

(instance flushSound of Sound
	(properties
		flags 1
		number 162
	)
)

(instance overFlow of Sound
	(properties
		flags 1
		number 163
		loop -1
	)
)

(instance sFX of Sound
	(properties)
)

(instance jSound of Sound
	(properties
		number 150
		loop -1
	)
)

