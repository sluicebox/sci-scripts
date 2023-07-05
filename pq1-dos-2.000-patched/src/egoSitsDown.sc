;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 152)
(include sci.sh)
(use Main)
(use station)
(use RangeOsc)
(use Inset)
(use Conversation)
(use Talker)
(use PolyPath)
(use DPath)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	egoSitsDown 1
	egoGetsUp 2
	getPaper 3
	timeOutEntry 4
	Officer 5
	proc152_6 6
	bugEgoToSit 7
)

(local
	local0
	local1
	local2 = -1
	local3
)

(procedure (proc152_6)
	(if (not (= local3 (< (gGame _detailLevel:) 3)))
		((ScriptID 15 2) startUpd: hide:) ; girlChair
		(girl init: 1)
		((ScriptID 15 4) startUpd: hide:) ; manChair2
		(man2 init: 1)
	)
	((ScriptID 15 5) startUpd: hide:) ; manChair3
	((ScriptID 15 3) startUpd: hide:) ; manChair1
	(man1 init: 1)
	(man3 init: 1)
	(dooley init: 1)
)

(instance egoGetsUp of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 152)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 number: 944 loop: 1 play:)
				(gEgo
					view: 131
					loop: 0
					cel: 7
					posn: (+ ((ScriptID 15 1) x:) 2) (+ ((ScriptID 15 1) y:) 7) ; chair1, chair1
					setCycle: Beg self
				)
			)
			(1
				((ScriptID 15 1) startUpd: show:) ; chair1
				(NormalEgo -1 0)
				(= cycles 3)
			)
			(2
				((ScriptID 15 1) stopUpd:) ; chair1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance girlComesIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girl x: 62 y: 97 setMotion: DPath 85 111 36 150 self)
			)
			(1
				(girl setMotion: MoveTo 110 175 self)
			)
			(2
				(girl setHeading: 45 self)
			)
			(3
				(gLongSong2 number: 944 loop: 1 play:)
				((ScriptID 15 2) startUpd: hide:) ; girlChair
				(girl
					view: 131
					loop: 6
					cel: 13
					posn: 110 174
					setCycle: Beg self
				)
			)
			(4
				(girl turnOffNormal: stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance girlLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girl
					startUpd:
					view: 131
					loop: 6
					cel: 0
					posn: 110 174
					setCycle: End self
				)
				(gLongSong2 number: 944 loop: 1 play:)
			)
			(1
				((ScriptID 15 2) show:) ; girlChair
				(girl
					turnOnNormal: 109 6
					posn: 110 175
					setMotion: DPath 36 150 85 111 62 97 self
				)
			)
			(2
				((ScriptID 15 2) stopUpd:) ; girlChair
				(girl dispose:)
				(self dispose:)
			)
		)
	)
)

(instance man1ComesIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(man1 x: 62 y: 97 setMotion: DPath 147 102 227 125 198 147 self)
			)
			(2
				(man1 setMotion: MoveTo 174 143 self)
			)
			(3
				(man1 setHeading: 0 self)
			)
			(4
				(gLongSong2 number: 944 loop: 1 play:)
				((ScriptID 15 3) startUpd: hide:) ; manChair1
				(man1 view: 131 loop: 0 cel: 0 posn: 173 143 setCycle: End self)
			)
			(5
				(man1 turnOffNormal: stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance man1Leaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(man1
					startUpd:
					view: 131
					loop: 0
					cel: 7
					posn: 173 143
					setCycle: Beg self
				)
				(gLongSong2 number: 944 loop: 1 play:)
			)
			(1
				((ScriptID 15 3) show:) ; manChair1
				(man1
					turnOnNormal: 110 3
					posn: 174 143
					setMotion: DPath 198 147 227 125 147 102 62 97 self
				)
			)
			(2
				((ScriptID 15 3) stopUpd:) ; manChair1
				(man1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance man2ComesIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(man2 x: 62 y: 97 setMotion: DPath 89 108 44 141 self)
			)
			(2
				(man2 setMotion: MoveTo 81 165 self)
			)
			(3
				(man2 setHeading: 0 self)
			)
			(4
				(gLongSong2 number: 944 loop: 1 play:)
				((ScriptID 15 4) startUpd: hide:) ; manChair2
				(man2 view: 131 loop: 0 cel: 0 posn: 81 165 setCycle: End self)
			)
			(5
				(man2 turnOffNormal: stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance man2Leaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(man2
					startUpd:
					view: 131
					loop: 0
					cel: 7
					posn: 81 165
					setCycle: Beg self
				)
			)
			(1
				(gLongSong2 number: 944 loop: 1 play:)
				((ScriptID 15 4) show:) ; manChair2
				(man2
					turnOnNormal: 110 3
					posn: 81 165
					setMotion: DPath 44 141 89 108 62 97 self
				)
			)
			(2
				((ScriptID 15 4) stopUpd:) ; manChair2
				(man2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance man3ComesIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(man3 x: 62 y: 97 setMotion: DPath 101 107 146 100 218 119 self)
			)
			(2
				(man3 setMotion: MoveTo 220 151 self)
			)
			(3
				(man3 setHeading: 45 self)
			)
			(4
				(gLongSong2 number: 944 loop: 1 play:)
				((ScriptID 15 5) startUpd: hide:) ; manChair3
				(man3 view: 131 loop: 9 cel: 0 posn: 238 149 setCycle: End self)
			)
			(5
				(man3 turnOffNormal: view: 131 loop: 5 cel: 0 posn: 238 149)
				(man3 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance man3Leaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(man3
					startUpd:
					view: 131
					loop: 9
					cel: 9
					posn: 238 149
					setCycle: Beg self
				)
			)
			(1
				(gLongSong2 number: 944 loop: 1 play:)
				((ScriptID 15 5) show:) ; manChair3
				(man3
					turnOnNormal: 110 6
					posn: 220 151
					setMotion: DPath 218 119 146 100 101 107 62 97 self
				)
			)
			(2
				((ScriptID 15 5) stopUpd:) ; manChair3
				(man3 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance dooleyEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dooley x: 62 y: 97 setMotion: MoveTo 114 110 self)
			)
			(1
				((ScriptID 15 7) startUpd: setCycle: Beg self) ; briefingRoomDoor
			)
			(2
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(3
				((ScriptID 15 7) stopUpd:) ; briefingRoomDoor
				(dooley setMotion: DPath 168 87 192 98 self)
			)
			(4
				(dooley setHeading: 225 self)
			)
			(5
				(dooley turnOffNormal:)
				(self dispose:)
			)
		)
	)
)

(instance dooleyLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dooley
					x: 192
					y: 98
					turnOnNormal: 132 5
					setMotion: DPath 150 88 98 110 self
				)
			)
			(1
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(2
				((ScriptID 15 7) startUpd: setCycle: End self) ; briefingRoomDoor
			)
			(3
				(dooley setMotion: MoveTo 60 98 self)
			)
			(4
				(dooley dispose:)
				(self dispose:)
			)
		)
	)
)

(instance dooleyGestures of Code
	(properties)

	(method (doit)
		(switch (= local1 (mod (+ local1 1) 4))
			(0
				(dooley
					view: 133
					loop: 0
					cel: 0
					posn: 191 98
					setCycle: RangeOsc 2 0 0 dooleyConv
				)
				(man3 setCycle: End)
			)
			(1
				(dooley
					view: 133
					loop: 1
					cel: 0
					posn: 195 98
					setCycle: RangeOsc 2 0 0 dooleyConv
				)
				(man3 setCycle: End)
			)
			(2
				(dooley
					view: 133
					loop: 2
					cel: 0
					posn: 192 97
					setCycle: RangeOsc 2 0 0 dooleyConv
				)
				(man3 setCycle: End)
			)
			(3
				(dooley
					view: 133
					loop: 3
					cel: 0
					posn: 195 98
					setCycle: RangeOsc 2 0 0 dooleyConv
				)
				(man3 setCycle: End)
			)
		)
	)
)

(instance timeOutEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(= next everyoneComesIn)
				(self dispose:)
			)
		)
	)
)

(instance bugEgoToSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (gEgo view:) 131)
					(gMessager say: 16 0 17 (++ local0) self 15)
				else
					(HandsOff)
					(= next doBriefing1)
					(self dispose:)
				)
			)
			(1
				(if (== local0 4)
					(= next killHim)
					(self dispose:)
				else
					(= seconds 10)
					(-= state 2)
				)
			)
		)
	)
)

(instance killHim of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 152)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(EgoDead 6)
			)
		)
	)
)

(instance jackThrowsWad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(man1
					startUpd:
					view: 131
					loop: 1
					cel: 0
					posn: 162 138
					setCycle: CT 3 1 self
				)
			)
			(1
				(paperWad init: setMotion: MoveTo 134 99)
				(dooleyGestures doit:)
				(man1 setCycle: End self)
			)
			(2
				(paperWad setMotion: JumpTo -10 200 self)
				(gEgo setCycle: Beg)
			)
			(3
				(paperWad dispose:)
				(gEgo
					view: 131
					loop: 0
					cel: 7
					posn: (+ ((ScriptID 15 1) x:) 2) (+ ((ScriptID 15 1) y:) 7) ; chair1, chair1
				)
				(self dispose:)
			)
		)
	)
)

(instance egoSlumps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 131
					loop: 3
					cel: 0
					posn: 133 130
					setCycle: End self
				)
				(dooleyGestures doit:)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance doBriefing1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong
					number: (if (== global211 2) 150 else 152)
					loop: -1
					play:
				)
				(if (== global211 2)
					(dooleyConv
						add: dooleyGestures
						add: 15 16 0 13 1 ; "Good morning, boys and girls. I trust you all had fun this weekend. I hope you didn't do anything I wouldn't do, haw haw haw!"
						add: egoSlumps
						add: 15 16 0 13 2 ; "Okay, it's time to get serious."
						add: dooleyGestures
						add: 15 16 0 13 3 ; "Sergeant Dooley clears his throat and goes over the daily hot sheet of stolen vehicles."
						add: jackThrowsWad
						add: 15 16 0 13 4 ; "Keep a special lookout for a black 1983 Mercedes Benz, license LOP123, VIN 603456218. This vehicle was reported stolen last week. We suspect it may be drug-related. Speaking of drugs, be sure to contact any and all informants who may know something about current developments in local drug trafficking. control, people."
						add: dooleyGestures
						add: 15 16 0 13 5 ; "This problem is out of hand, people. Three more teenagers were arrested last night for drunk driving. Two of them were in possession of cocaine, and all three of them tested positive for it. That's pretty grim news, team. We're not doing our jobs. We all have to work together on this, before it's too late."
						add: dooleyGestures
						add: 15 16 0 13 6 ; "Let's get out there and clean things up, boys and girls! And please, everybody be careful out there. This is a lot rougher crowd than we're used to dealing with in little old Lytton. We've got to get their numbers...before they get ours."
						add: dooleyGestures
						add: 15 16 0 13 7 ; "Speaking of numbers, Bonds, your new call number is 83-32. And don't let that newspaper article make your head swell. It would make too big of a target, haw haw haw! Okay, let's get moving. Remember, caution, boys and girls, caution!"
						init: self
					)
				else
					(dooleyConv
						add: dooleyGestures
						add: 15 15 0 15 1 ; "First off, thank you for taking time away from your usual afternoon debaucheries to come back to work. There's some late-breaking news on that stolen Mercedes. A missing persons report was filed earlier in the day by the wife of a certain Jose Martinez, Hispanic male, 145 pounds, brown eyes, black hair."
						add: egoSlumps
						add: 15 15 0 15 2 ; "It seems this gentleman was last seen two days ago, getting into a fairly late-model black Benz. No one has seen or heard from him since. Wait, it gets better. Martinez has an arrest record involving the sale of narcotics. Be careful, people. This car may have been the one involved in the murder of Lonny West."
						add: dooleyGestures
						add: 15 15 0 15 3 ; "Let's get moving on this one, boys and girls, before anyone else dies. Keep your heads down, your eyes open, and above all, watch your backs! Okay, let's move out. And hey, find me that Mercedes before its owner, Malcolm Washington, deep-fries my ass. Let's go!"
						add: dooleyGestures
						init: self
					)
				)
			)
			(1
				(gLongSong client: self)
			)
			(2
				(gLongSong
					number: (if (== global211 2) 151 else 153)
					loop: 1
					play: self
				)
				(self setScript: dooleyLeaves self)
			)
			(3)
			(4
				(man1 setScript: man1Leaves self)
				(man3 setScript: man3Leaves self)
				(if (not local3)
					(man2 setScript: man2Leaves self)
					(girl setScript: girlLeaves self)
				)
			)
			(5)
			(6
				(if local3
					(= cycles 1)
				)
			)
			(7
				(if local3
					(= cycles 1)
				)
			)
			(8
				((ScriptID 15 7) startUpd: setCycle: Beg self) ; briefingRoomDoor
			)
			(9
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(10
				((ScriptID 15 7) stopUpd:) ; briefingRoomDoor
				(= next egoGetsUp)
				(self dispose:)
			)
		)
	)
)

(instance doBriefing2 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(self setScript: dooleyLeaves self)
			)
			(2
				(man1 setScript: man1Leaves self)
				(man2 setScript: man2Leaves self)
				(man3 setScript: man3Leaves self)
				(girl setScript: girlLeaves self)
			)
			(3)
			(4)
			(5)
			(6
				((ScriptID 15 7) startUpd: setCycle: Beg self) ; briefingRoomDoor
			)
			(7
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(8
				((ScriptID 15 7) stopUpd:) ; briefingRoomDoor
				(= next egoGetsUp)
				(self dispose:)
			)
		)
	)
)

(instance gab of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom notify:)
				(= local2 (mod (+ local2 1) 3))
				(gMessager say: 16 0 18 (+ local2 1) self)
			)
			(1
				(client restoreState:)
				(= client 0)
			)
		)
	)
)

(instance dooleyGab of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(if (OneOf (client view:) 0 1 2 124 125 177)
					(Face client gEgo self)
				else
					(= ticks 3)
				)
			)
			(1
				(= temp1 (- (NumLoops client) 1))
				(= temp2 (client loop:))
				(if (OneOf (client view:) 0 1 2 124 125 177)
					(client loop: temp1 setCel: temp2 forceUpd:)
				)
				(= cycles 1)
			)
			(2
				(client lastPhrase: (mod (+ (client lastPhrase:) 1) 3))
				(gMessager say: 16 0 18 (+ (client lastPhrase:) 4) self)
			)
		)
	)
)

(instance bigNewsPaper of Inset
	(properties
		view 136
		x 167
		y 162
		priority 15
		disposeNotOnMe 1
		noun 5
	)

	(method (dispose)
		(getPaper cue:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1 8 0 0 15) ; "You pick up the paper, and scan the leading stories:"
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance girl of Officer
	(properties
		view 109
	)

	(method (init param1)
		(super init: &rest)
		(= gabScript gab)
		(if (and argc param1)
			(self
				view: 131
				loop: 6
				cel: 0
				posn: 110 174
				turnOffNormal:
				stopUpd:
			)
		else
			(proc134_4 self)
		)
	)
)

(instance man1 of Officer
	(properties
		view 110
	)

	(method (dispose)
		(gabScript dispose:)
		(super dispose: &rest)
	)

	(method (init param1)
		(super init: &rest)
		(= gabScript gab)
		(if (and argc param1)
			(self
				view: 131
				loop: 0
				cel: (self lastCel:)
				posn: 173 143
				turnOffNormal:
				stopUpd:
			)
		else
			(proc134_4 self)
		)
	)
)

(instance man2 of Officer
	(properties
		view 110
	)

	(method (dispose)
		(gabScript dispose:)
		(super dispose: &rest)
	)

	(method (init param1)
		(super init: &rest)
		(= gabScript gab)
		(if (and argc param1)
			(self
				view: 131
				loop: 0
				cel: (self lastCel:)
				posn: 81 165
				turnOffNormal:
				stopUpd:
			)
		else
			(proc134_4 self)
		)
	)
)

(instance man3 of Officer
	(properties
		view 110
	)

	(method (dispose)
		(gabScript dispose:)
		(super dispose: &rest)
	)

	(method (init param1)
		(super init: &rest)
		(= gabScript gab)
		(if (and argc param1)
			(self
				view: 131
				loop: 5
				cel: 0
				posn: 238 149
				turnOffNormal:
				stopUpd:
			)
		else
			(proc134_4 self)
		)
	)
)

(instance dooley of Officer
	(properties
		view 132
	)

	(method (init param1)
		(super init: &rest)
		(= gabScript dooleyGab)
		(if (and argc param1)
			(self heading: 225 loop: 5 posn: 192 98 turnOffNormal:)
		else
			(proc134_4 self)
		)
	)
)

(instance Officer of Narrator
	(properties
		x 150
		y 100
		talkWidth 130
		showTitle 1
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance dooleyConv of Conversation
	(properties)
)

(instance paperWad of Actor
	(properties
		x 141
		y 102
		view 134
		priority 15
		signal 18448
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance getPaper of Script
	(properties)

	(method (dispose)
		(if (< global211 2)
			(= next everyoneComesIn)
			(super dispose: &rest)
		else
			(HandsOn)
			(super dispose: &rest)
			(DisposeScript 152)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 45 self)
			)
			(1
				(gEgo loop: 0 view: 630 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				((ScriptID 15 6) hide:) ; newspaper
				(gCurRoom setInset: bigNewsPaper)
				(= seconds 3)
			)
			(3
				(gMessager say: 5 1 8 0 self 15) ; "You pick up the paper, and scan the leading stories:"
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 2 0 3 4 5)
			)
			(5
				(= seconds 2)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				((ScriptID 15 6) show:) ; newspaper
				(gMessager say: 5 4 11 0 self 15) ; "You close the paper, still grinning."
			)
			(8
				(NormalEgo -1 6)
				(gEgo loop: 6 posn: 116 127)
				(HandsOn)
				(gTheIconBar disable: 3 4 5)
				(self dispose:)
			)
		)
	)
)

(instance everyoneComesIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(1
				((ScriptID 15 7) startUpd: setCycle: End self) ; briefingRoomDoor
			)
			(2
				(if (>= (gGame _detailLevel:) 3)
					(girl init: setScript: girlComesIn self)
					(man2 init: setScript: man2ComesIn self)
					(= local3 0)
				else
					(= local3 1)
				)
				(man1 init: setScript: man1ComesIn self)
				(man3 init: setScript: man3ComesIn self)
			)
			(3
				((ScriptID 15 7) startUpd: setCycle: Beg) ; briefingRoomDoor
			)
			(4
				(gLongSong2 number: 914 loop: 1 play:)
				(if local3
					(= cycles 1)
				)
			)
			(5
				(if local3
					(= cycles 1)
				)
			)
			(6
				(= seconds 7)
			)
			(7
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(8
				((ScriptID 15 7) startUpd: setCycle: End self) ; briefingRoomDoor
			)
			(9
				(dooley init: setScript: dooleyEnters self)
			)
			(10
				(= next bugEgoToSit)
				(self dispose:)
			)
		)
	)
)

(instance egoSitsDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (!= (gEgo x:) 135) (!= (gEgo y:) 134))
					(-- state)
					(gEgo setMotion: PolyPath 135 134 self)
				else
					(gEgo setHeading: 0 self)
				)
			)
			(1
				(gLongSong2 number: 944 loop: 1 play:)
				((ScriptID 15 1) startUpd: hide:) ; chair1
				(gEgo
					view: 131
					loop: 0
					cel: 0
					posn: (+ ((ScriptID 15 1) x:) 2) (+ ((ScriptID 15 1) y:) 7) ; chair1, chair1
					setCycle: End self
				)
			)
			(2
				((ScriptID 15 1) stopUpd:) ; chair1
				(++ global211)
				(if (== (gCurRoom script:) timeOutEntry)
					(gCurRoom setScript: everyoneComesIn)
				)
				(self dispose:)
			)
		)
	)
)

