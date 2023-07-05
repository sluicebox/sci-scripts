;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use n882)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm021 0
	sonnyInset 1
	sitScript 2
	standScript 3
	door 4
	cInset 5
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(HandsOn)
	(if (not (gEgo normal:))
		(gTheIconBar disable: 0)
	)
)

(instance rm021 of PQRoom
	(properties
		picture 21
	)

	(method (init)
		(sFX init:)
		(ScriptID 882)
		(ScriptID 941) ; MISSING EXPORT
		(super init:)
		(= local2 gUseSortedFeatures)
		(= gUseSortedFeatures 1)
		(roomWindow init:)
		(graphChart init:)
		(bookCase init:)
		(bulletin init:)
		(cabinet init:)
		(captDesk init:)
		(patDesk init:)
		(earlDesk init:)
		(yourDesk init:)
		(door init:)
		(thePhone init:)
		(pDrawer init:)
		(computer init:)
		(chair init:)
		(gChair init:)
		(thisRoom init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 199 77 166 87 158 90 173 105 174 113 165 119 148 121 135 113 115 95 102 95 92 104 96 121 22 141 22 183 284 178 284 128
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 88 167 66 146 137 123 157 145 132 155 133 159 117 166 105 163 88 166
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 171 133 241 107 259 126 221 140 241 154 208 165
					yourself:
				)
			setRegions: 891 ; station
		)
		(switch gPrevRoomNum
			(200
				(gEgo
					normal: 0
					view: 236
					setLoop: 1
					posn: (- (chair x:) 2) (+ (chair y:) 5)
					cel: 12
					init:
				)
				(chair hide:)
				(localproc_0)
			)
			(10
				(self setRegions: 876) ; bagger
				(gEgo view: 4 setStep: 3 2 posn: 200 101 loop: 1 init:)
			)
			(else
				(gEgo
					view: (if (> gDay 1) 4 else 0)
					setStep: 3 2
					posn: 236 101
					loop: 1
					init:
				)
				((gEgo head:) cel: 1)
				(gCurRoom setScript: enterScript)
			)
		)
		(switch gDay
			(1
				(eChair init:)
				(captain init:)
				(pChair init:)
			)
			(2
				(self setRegions: 421) ; rmHomo
				(cChair init:)
				(if (not (IsFlag 229))
					(pat init:)
				)
				(if (not (IsFlag 18))
					(SetFlag 18)
					(captain init:)
					(cChair hide:)
					(HandsOff)
					(self setScript: introductions)
				)
			)
			(3
				(eChair init:)
				(self setRegions: 876) ; bagger
				(if (and (IsFlag 19) (not (IsFlag 138)))
					(note init:)
				)
				(if (not (IsFlag 21))
					(pat init:)
					(pat setScript: patLeaves)
				else
					(localproc_0)
					(pChair init:)
				)
				(cChair init:)
			)
			(4
				(eChair init:)
				(cond
					(
						(and
							(IsFlag 221)
							(not (IsFlag 28))
							(not (IsFlag 29))
						)
						(note init:)
					)
					((and (IsFlag 80) (not (IsFlag 205)))
						(note init:)
					)
					(
						(and
							(not (IsFlag 221))
							(not (IsFlag 80))
							(not (IsFlag 63))
						)
						(note init:)
					)
				)
				(if (not (IsFlag 22))
					(pat init:)
					(pat setScript: patLeaves)
				else
					(localproc_0)
					(pChair init:)
				)
				(cChair init:)
			)
			(5
				(if (and (not (IsFlag 31)) (!= gPrevRoomNum 200))
					(self setRegions: 421) ; rmHomo
				else
					(eChair init:)
				)
				(if (not (IsFlag 23))
					(pat init:)
					(pat setScript: patLeaves)
				else
					(localproc_0)
					(pChair init:)
				)
				(if (and (IsFlag 31) (not (IsFlag 60)))
					(note init:)
				)
				(cChair setScript: capt5Script init:)
			)
			(6
				(eChair init:)
				(if (IsFlag 218)
					(captain init:)
					(pChair init:)
					(if (not (gEgo has: 2)) ; handcuff
						(captain setScript: forgotCuffs)
					)
				else
					(cChair init:)
				)
			)
		)
	)

	(method (dispose)
		(= gUseSortedFeatures local2)
		(DisposeScript 882)
		(super dispose:)
		(DisposeScript 421)
		(DisposeScript 876)
	)
)

(instance byebye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(patInset init:)
				(Say patInset 21 0) ; "I'll catch up with you later, Sonny."
				(= seconds 3)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 4)
			)
			(1
				(sFX number: 908 play:)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: MoveTo 233 104 self)
			)
			(3
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
				(if (gEgo normal:)
					(= cycles 1)
				else
					(self setScript: standScript self)
				)
			)
			(1
				(HandsOff)
				(gEgo setMotion: PolyPath 236 101 self)
			)
			(2
				(Face gEgo door self)
			)
			(3
				(door setCycle: End self)
				(sFX number: 907 play:)
			)
			(4
				(if (gCast contains: pat)
					(self setScript: byebye self)
				else
					(= cycles 1)
				)
			)
			(5
				(gEgo setMotion: MoveTo 263 94 self)
			)
			(6
				(gCurRoom newRoom: 18)
			)
		)
	)
)

(instance sitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (+ (chair x:) 1) (+ (chair y:) 6) self
				)
				(sFX fade:)
			)
			(1
				(gEgo
					normal: 0
					view: 236
					setLoop: 1
					posn: (- (chair x:) 2) (+ (chair y:) 5)
					cel: 0
					setCycle: End self
				)
				(sFX number: 947 play:)
				(chair hide:)
			)
			(2
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance standScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cInset dispose:)
				(gEgo normal: 0 view: 236 loop: 1 cel: 12 setCycle: Beg self)
				(sFX number: 947 play:)
			)
			(1
				(chair show:)
				(gEgo
					normal: 1
					view: 4
					setLoop: -1
					setCycle: Walk
					posn: (+ (chair x:) 1) (+ (chair y:) 6)
				)
				(localproc_0)
				(gTheIconBar enable: 0)
				(self dispose:)
			)
		)
	)
)

(instance compScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo normal:)
					(self setScript: sitScript self)
				else
					(= cycles 1)
				)
			)
			(1
				(cInset init:)
				(localproc_0)
			)
		)
	)
)

(instance phone21Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo normal:)
					(self setScript: sitScript self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo loop: 0 cel: 0)
				(self setScript: (ScriptID 891 2) self) ; phoneScript
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance noteScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo normal:)
					(gEgo setMotion: PolyPath 129 113 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Face gEgo note)
				(Animate (gCast elements:) 0)
				(switch gDay
					(3
						(note hide:)
						(Animate (gCast elements:) 0)
						(Print 21 1) ; "You pick up and read the message..."
						(Print 21 2) ; "Bonds, a Carla Reed called for you. Said she saw the newspaper article about Marie."
						(Print 21 3) ; "Better get on over there. I think she may have something for you."
						(Print 21 4) ; "Strange address though. 325 South Second St. That's the old industrial park."
						(note dispose:)
						(SetFlag 61)
						(SetFlag 4)
						(SetScore 138 1)
						(proc0_17 30)
					)
					(4
						(note hide:)
						(Animate (gCast elements:) 0)
						(cond
							((IsFlag 80)
								(Print 21 5) ; "Sonny, Dr. Wagner called and would like you to stop by the hospital."
								(SetFlag 60)
								(SetFlag 205)
								(SetScore 157 1)
								(proc0_17 15)
							)
							(
								(and
									(not (IsFlag 221))
									(not (IsFlag 80))
									(not (IsFlag 63))
								)
								(Print 21 6) ; "You pick up a message from the Captain."
								(Print 21 7) ; "Sonny, drive out to the 300 block of W. Rose. There's a murder victim that you better have a look at."
								(SetFlag 63)
							)
							((not (IsFlag 28))
								(Print 21 8) ; "You remove the subpoena."
								(Print 21 9) ; "You are commanded to appear in the Lytton Municipal Court as a witness in the case of People VS. Juan Ruiz."
								(Print 21 10) ; "You remember that you cited Mr. Ruiz for impeding traffic."
								(SetFlag 28)
								(SetFlag 62)
								(SetScore 144 1)
								(proc0_17 15)
							)
						)
						(note dispose:)
					)
					(5
						(note hide:)
						(Animate (gCast elements:) 0)
						(if (IsFlag 31)
							(Print 21 11) ; "The note reads:"Sonny, Dr. Wagner called again to remind you that it is important for you to see Marie every day.""
							(SetFlag 60)
							(SetScore 201 1)
							(proc0_17 15)
						)
						(note dispose:)
					)
				)
				(= cycles 5)
			)
			(2
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance patLeaves of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (gCurRoom script:)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(HandsOff)
				(gEgo setMotion: PolyPath 200 97 self)
			)
			(3
				(if (== gDay 3)
					(= save1 1)
					(patInset init:)
					(Say patInset 21 12) ; "Afternoon, Bonds!"
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(pat view: 240 loop: 3 cel: 0 setCycle: CT 6 1 self)
			)
			(5
				(= seconds 2)
			)
			(6
				(sFX number: 213 play: self)
			)
			(7
				(pat setCycle: End self)
			)
			(8
				(= save1 1)
				(patInset init:)
				(switch gDay
					(2
						(Say patInset 21 13) ; "Hey, Sonny. I'm goin' to the locker room. If ya get lonely, just holler, eh? Oh, and don't let anybody mess with my stuff."
						(= seconds 8)
					)
					(3
						(Say patInset 21 14) ; "I was just on my way to the locker room. I'll be back in a minute, if you need me."
						(= seconds 6)
					)
					(4
						(if (not (IsFlag 221))
							(Say patInset 21 15) ; "We got a call for a homicide at the 300 block of west Rose. I'll meet you in the garage."
							(= seconds 8)
						else
							(Say patInset 21 16) ; "Gotta take care of some woman stuff Bonds. Be right back."
							(= seconds 5)
						)
					)
					(5
						(Say patInset 21 17) ; "Yo Bonds! Be back in a sec."
						(= seconds 3)
					)
				)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(pat view: 22 setCycle: Walk setMotion: PolyPath 221 97 self)
				(pChair init:)
			)
			(10
				(door setCycle: End self)
				(sFX number: 907 play:)
			)
			(11
				(pat setMotion: MoveTo 263 94 self)
			)
			(12
				(pat hide:)
				(door setCycle: Beg self)
			)
			(13
				(sFX number: 908 play:)
				(= cycles 1)
			)
			(14
				(switch gDay
					(2
						(SetFlag 20)
					)
					(3
						(SetFlag 21)
					)
					(4
						(SetFlag 22)
					)
					(5
						(SetFlag 23)
					)
				)
				(door stopUpd:)
				(localproc_0)
				(pat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance captTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo normal:) 1)
					(gEgo setMotion: PolyPath 204 120 self)
				else
					(= cycles 1)
				)
			)
			(1
				(= save1 1)
				(captInset init:)
				(if local0
					(Say captInset 21 18) ; "Sergeant, don't you think you'd better get back out on the streets where you belong?"
					(= seconds 8)
				else
					(Say captInset 21 19) ; "Sergeant Bonds. Good to see you. Sorry I can't talk. Got an Internal Affairs meeting, and I have to finish writing this report."
					(= seconds 8)
					(++ local0)
				)
			)
			(2
				(captInset dispose:)
				(localproc_0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance introductions of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 185 125 self)
			)
			(1
				(Face gEgo captain)
				(= cycles 15)
			)
			(2
				(= save1 1)
				(captInset init:)
				(Say captInset 21 20) ; "Welcome back, Bonds."
				(= seconds 3)
			)
			(3
				(= save1 1)
				(Say captInset 21 21) ; "I'm sorry to hear about your wife, Marie."
				(= seconds 4)
			)
			(4
				(= save1 1)
				(Say captInset 21 22) ; "I'm assigning you to her case, since I know you won't be able to concentrate on anything else."
				(= seconds 4)
			)
			(5
				(= save1 1)
				(Say captInset 21 23) ; "Marie's case number is 199144."
				(= seconds 4)
			)
			(6
				(= save1 1)
				(Say captInset 21 24) ; "You might want to review another stabbing case to see if there are any similarities."
				(= seconds 7)
			)
			(7
				(= save1 1)
				(Say captInset 21 25) ; "That case number is 199137."
				(= seconds 3)
			)
			(8
				(= save1 1)
				(Say captInset 21 26) ; "By the way, I want to introduce you to your new partner."
				(= seconds 4)
			)
			(9
				(= save1 1)
				(Say captInset 21 27) ; "Officer Bonds, meet Officer Pat Morales, your new partner."
				(= seconds 4)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(captInset dispose:)
				(gEgo setMotion: PolyPath 160 134 self)
			)
			(11
				(sonnyInset init:)
				(Say sonnyInset 21 28) ; "Oh no, not you!?"
				(= seconds 3)
			)
			(12
				(sonnyInset dispose:)
				(patInset init:)
				(= save1 1)
				(Say patInset 21 29) ; "Hey, Bonds. Looks like we're stuck together, eh?"
				(= seconds 5)
			)
			(13
				(= save1 1)
				(Say patInset 21 30) ; "Sorry if I've been a little rough around the edges lately. I'm not so bad once you get to know me."
				(= seconds 9)
			)
			(14
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(if (gEgo has: 32) ; bronzeStar
					(= cycles 1)
				else
					(SetFlag 59)
					(captain setScript: captRanTalk)
					(localproc_0)
					(self dispose:)
				)
			)
			(15
				(captain setCycle: End self)
			)
			(16
				(cChair show:)
				(captain
					view: 248
					posn: (+ (captain x:) 10) (- (captain y:) 3)
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 268 132 self
				)
			)
			(17
				(captain setLoop: 2 setMotion: MoveTo 240 108 self)
			)
			(18
				(door setCycle: End self)
				(sFX number: 907 play:)
			)
			(19
				(captain setLoop: 2 setMotion: MoveTo 221 100 self)
			)
			(20
				(captain setLoop: 1 setMotion: MoveTo 263 94 self)
			)
			(21
				(captain dispose:)
				(door setCycle: Beg self)
			)
			(22
				(sFX number: 908 play:)
				(= cycles 1)
			)
			(23
				(door stopUpd:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance captRanTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(if (not (gCurRoom script:))
					(gCurRoom setScript: cRTalk)
					(self dispose:)
				else
					(= state 0)
					(= cycles 1)
				)
			)
		)
	)
)

(instance cRTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(HandsOff)
				(captInset init:)
				(switch local0
					(0
						(Say captInset 21 31) ; "Listen, Sonny. I...I can't begin to imagine what you must be going through. But I want you to know that the entire department is pulling for you to catch the thug who did this."
					)
					(1
						(Say captInset 21 32) ; "I admire your ability to maintain a professional attitude through this hardship. You are to be commended. I just wanted to remind you to examine the scene of the crime thoroughly."
					)
					(2
						(Say captInset 21 33) ; "Have you been back to the mall to look for any physical evidence in Marie's stabbing yet?"
					)
					(3
						(Say captInset 21 34) ; "Bonds, don't let your emotional state over Marie's injuries distract you from making a comprehensive sweep of the crime site."
					)
					(else
						(Say captInset 21 35) ; "Bonds, I understand you're getting sloppy on this case. Get your butt back to the mall and search that crime area again, damnit!"
					)
				)
				(= seconds 8)
			)
			(1
				(localproc_0)
				(captInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(++ local0)
				(captain setScript: captRanTalk)
				(self dispose:)
			)
		)
	)
)

(instance patRandom of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= save1 1)
				(patInset init:)
				(switch local1
					(0
						(Say patInset 21 36) ; "Don't worry, your lady will pull through."
						(= seconds 3)
					)
					(1
						(Say patInset 21 37) ; "I hope Marie's doin' better."
						(= seconds 3)
					)
					(2
						(Say patInset 21 38) ; "Marie's gotta be one tough cookie to have put up with you this long, Sonny. She'll be alright."
						(= seconds 5)
					)
					(3
						(Say patInset 21 39) ; "Major drag about Marie, Sonny. Hope she pulls through."
						(= seconds 5)
					)
				)
			)
			(1
				(++ local1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(localproc_0)
				(patInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance openDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo normal:)
					(= cycles 1)
				else
					(self setScript: standScript self)
				)
			)
			(1
				(gEgo setMotion: PolyPath 143 157 self)
			)
			(2
				(sFX number: 914 play:)
				(= seconds 1)
			)
			(3
				(localproc_0)
				(sFX number: 201 play:)
				(pChair setScript: drawerTimerScript)
				(drawerInset init:)
				(self dispose:)
			)
		)
	)
)

(instance capt5Talk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo normal:) 1)
					(gEgo setMotion: PolyPath 204 120 self)
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((IsFlag 30)
						(if local0
							(Say captInset 21 40) ; "Well Bonds! Get out there and catch some bad guys!."
						else
							(Print 21 41) ; "You advise the captain of the pentagram pattern based on the murder locations, times, and dates."
							(Print 21 42) ; "You also tell him the possible location of the next hit."
							(captInset init:)
							(Say captInset 21 43) ; "Well that doesn't leave much you time, Bonds!"
						)
						(= seconds 4)
						(proc0_17 20)
					)
					(global150
						(if (and (== gDay 5) global143)
							(= save1 1)
							(captInset init:)
							(if local0
								(Say captInset 21 44) ; "Did you check your computer Bonds? Better take a look!"
								(= seconds 4)
							else
								(Say captInset 21 45) ; "You seen the messages on your computer, Bonds? Better take a look!"
								(= seconds 4)
							)
						else
							(= cycles 1)
						)
					)
					((not (IsFlag 33))
						(= save1 1)
						(captInset init:)
						(if local0
							(Say captInset 21 46) ; "Have you called dispatch with that description yet?"
						else
							(Say captInset 21 47) ; "You may want to get that description on the air."
						)
						(= seconds 4)
					)
					(else
						(captInset init:)
						(Say captInset 21 40) ; "Well Bonds! Get out there and catch some bad guys!."
						(= seconds 4)
					)
				)
			)
			(2
				(captInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance capt5Script of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(if (or global150 (not (IsFlag 33)) (IsFlag 30))
					(HandsOff)
					(door setCycle: End self)
					(sFX number: 907 play:)
				else
					(self init:)
				)
			)
			(2
				(door stopUpd:)
				(captain
					view: 248
					setLoop: 3
					posn: 263 94
					setCycle: Walk
					setMotion: MoveTo 221 97 self
					init:
				)
			)
			(3
				(door setCycle: Beg self)
			)
			(4
				(sFX number: 908 play:)
				(= cycles 1)
			)
			(5
				(door stopUpd:)
				(captain setLoop: 4 setMotion: MoveTo 268 132 self)
			)
			(6
				(captain setLoop: 3 setMotion: MoveTo 234 136 self)
			)
			(7
				(captain view: 241 setLoop: 0 cel: 12 setCycle: Beg self)
				(cChair hide:)
			)
			(8
				(if (gCast contains: cInset)
					(cInset dispose:)
				)
				(cond
					((IsFlag 30)
						(Print 21 41) ; "You advise the captain of the pentagram pattern based on the murder locations, times, and dates."
						(Print 21 42) ; "You also tell him the possible location of the next hit."
						(Print 21 48) ; "Well that doesn't leave much time Bonds!"
						(proc0_17 20)
						(++ state)
					)
					(global150
						(= save1 1)
						(captInset init:)
						(Say captInset 21 49) ; "You seen the messages on your computer Bonds? Better take a look!"
						(= seconds 4)
					)
					((not (IsFlag 33))
						(= save1 1)
						(captInset init:)
						(Say captInset 21 47) ; "You may want to get that description on the air."
						(= seconds 4)
					)
				)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(captInset dispose:)
				(localproc_0)
				(self dispose:)
			)
			(10
				(localproc_0)
				(= seconds 30)
			)
			(11
				(HandsOff)
				(captInset init:)
				(= save1 1)
				(Say captInset 21 50) ; "Bonds! I want you to get over to the 200 block of River Road, now!"
				(= seconds 7)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(captInset dispose:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance drawerTimerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 15)
			)
			(1
				(cond
					((gCast contains: drawerInset)
						(drawerInset dispose:)
						(HandsOff)
						(door setCycle: End self)
						(sFX number: 907 play:)
					)
					((IsFlag 34)
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(2
				(Face gEgo door)
				(door stopUpd:)
				(pat
					view: 22
					posn: 263 94
					setMotion: MoveTo 221 97 self
					setCycle: Walk
					init:
				)
			)
			(3
				(door setCycle: Beg self)
			)
			(4
				(sFX number: 908 play:)
				(= cycles 1)
			)
			(5
				(door stopUpd:)
				(Print 21 51) ; "You feel a warm flushed feeling comes over you as Morales walks in and catches you in her drawer."
				(= cycles 1)
			)
			(6
				(patInset init:)
				(Say patInset 21 52) ; "HEY! You mind telling me what the hell you're doing in my desk? That's breaking and entering. Your going to hang for this, Bonds!"
				(= seconds 7)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(= cycles 6)
			)
			(8
				(EgoDead 31) ; "BUSTED! Morales gets you suspended. Try being a little faster next time."
			)
		)
	)
)

(instance forgotCuffs of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (gCurRoom script:)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(HandsOff)
				(gEgo setMotion: PolyPath 185 125 self)
			)
			(3
				(Face gEgo captain)
				(= cycles 15)
			)
			(4
				(= save1 1)
				(captInset init:)
				(Say captInset 21 53) ; "Hey Bonds, you better quit leaving department equipment lying around. That baglady had a fit not being able to move her shopping cart."
				(= seconds 6)
			)
			(5
				(captInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 21 54) ; "You turn bright red as the captain hands back your cuffs you forgot at the warehouse."
				(gEgo get: 2) ; handcuff
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lastDay of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo normal:)
					(= cycles 1)
				else
					(self setScript: standScript self)
				)
			)
			(1
				(HandsOff)
				(gEgo setMotion: PolyPath 185 125 self)
			)
			(2
				(Face gEgo captain)
				(= cycles 15)
			)
			(3
				(= save1 1)
				(captInset init:)
				(Say captInset 21 55) ; "Bonds, the coroner called and said he has something important for you."
				(= seconds 6)
			)
			(4
				(= save1 1)
				(Say captInset 21 56) ; "Something he found on the fatal crash victim last night. Better get over to see him,.. pronto!"
				(= seconds 6)
			)
			(5
				(captInset dispose:)
				(captain setCycle: End self)
			)
			(6
				(cChair init:)
				(captain
					view: 248
					posn: (+ (captain x:) 10) (- (captain y:) 3)
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 268 132 self
				)
			)
			(7
				(captain setLoop: 2 setMotion: MoveTo 224 102 self)
			)
			(8
				(SetFlag 65)
				(= save1 1)
				(captInset init:)
				(Say captInset 21 57) ; "Your partner should be back from her physical testing any second."
				(= seconds 6)
			)
			(9
				(captInset dispose:)
				(door setCycle: End self)
				(sFX number: 907 play:)
			)
			(10
				(captain setLoop: 1 setMotion: MoveTo 263 94 self)
			)
			(11
				(captain dispose:)
				(door setCycle: Beg self)
			)
			(12
				(sFX number: 908 play:)
				(= cycles 1)
			)
			(13
				(ClearFlag 218)
				(door stopUpd:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance turnPatIn of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo normal:)
					(= cycles 1)
				else
					(self setScript: standScript self)
				)
			)
			(1
				(gEgo setMotion: PolyPath 204 120 self)
			)
			(2
				(Face gEgo captain)
				(= cycles 15)
			)
			(3
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 21 58) ; "Captain, I have reason to believe that my partner, Morales, has stolen some of the evidence from the Rocklin case.  There were five bags of cocaine removed from accident scene, but only four were checked in as evidence."
				(= seconds 6)
			)
			(4
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 21 59) ; "I'm also beginning to suspect that she may be in league with this cult."
				(= seconds 4)
			)
			(5
				(sonnyInset dispose:)
				(captInset init:)
				(Say captInset 21 60) ; "Alright Bonds, I'll have the Internal Affairs boys check it out and keep an eye on her. Play it straight but be careful."
				(= seconds 6)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(captInset dispose:)
				(HandsOn)
				(SetFlag 48)
				(SetScore 175 5)
				(proc0_17 10)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 239
		y 89
		lookStr {The door leads back into the hallway.}
		view 234
		loop 3
		signal 16385
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: exitScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance computer of Feature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cond
					(
						(OneOf
							(gEgo view:)
							0
							1
							3
							8
							10
							11
							12
							16
							124
							125
							127
							165
							315
							333
						)
						(Print 21 61) ; "You're not in the homicide division."
					)
					(global150
						(switch global150
							(1
								(if (and (== gDay 5) global143)
									(Print 21 62) ; "You have messages on your computer."
								else
									(Print 21 63) ; "This is your computer."
								)
							)
							(2
								(Print 21 62) ; "You have messages on your computer."
							)
						)
					)
					(else
						(Print 21 63) ; "This is your computer."
					)
				)
			)
			(3 ; Do
				(cond
					((== gDay 1)
						(Print 21 61) ; "You're not in the homicide division."
					)
					((gCast contains: cInset)
						(Print 21 64) ; "Your computer is already turned on."
					)
					(else
						(HandsOff)
						(gCurRoom setScript: compScript)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePhone of View
	(properties
		x 120
		y 100
		z 24
		description {your phone}
		lookStr {A phone.}
		view 234
		priority 1
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== gDay 1)
					(Print 21 61) ; "You're not in the homicide division."
				else
					(HandsOff)
					(cInset dispose:)
					(gCurRoom setScript: phone21Script)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chair of Prop
	(properties
		x 116
		y 93
		description {chair}
		view 234
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== gDay 1)
					(Print 21 65) ; "The chairs are for officers assigned to Homicide."
				else
					(Print 21 66) ; "Your chair isn't exactly a lazy boy, but you like it."
				)
			)
			(3 ; Do
				(cond
					(
						(OneOf
							(gEgo view:)
							0
							1
							3
							8
							10
							11
							12
							16
							124
							125
							127
							165
							315
							333
						)
						(Print 21 61) ; "You're not in the homicide division."
					)
					((not (gEgo normal:))
						(Print 21 67) ; "You are already sitting down."
					)
					(else
						(HandsOff)
						(gCurRoom setScript: sitScript)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pChair of Prop
	(properties
		x 120
		y 154
		description {chair}
		view 234
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== gDay 1)
					(Print 21 65) ; "The chairs are for officers assigned to Homicide."
				else
					(Print 21 68) ; "That's where Pat sits."
				)
			)
			(3 ; Do
				(if (== gDay 1)
					(Print 21 61) ; "You're not in the homicide division."
				else
					(Print 21 69) ; "Sit in your own chair, Sonny."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pDrawer of Feature
	(properties
		description {drawer}
		onMeCheck 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (> gDay 1)
					(Print 21 70) ; "It's Pat's desk drawer."
				else
					(Print 21 71) ; "The desks are for officers assigned to Homicide."
				)
			)
			(3 ; Do
				(Print 21 72) ; "It's locked."
			)
			(4 ; Inventory
				(switch invItem
					(3 ; theKeys
						(cond
							((not (proc882_2 8))
								(Print 21 73) ; "You don't have the key."
							)
							(
								(or
									(gCast contains: pat)
									(gCast contains: captain)
									(not (gCast contains: eChair))
								)
								(Print 21 74) ; "Better not while people are in the room."
							)
							(else
								(HandsOff)
								(gCurRoom setScript: openDrawer)
							)
						)
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

(instance drawerInset of View
	(properties
		x 78
		y 184
		description {drawer}
		view 238
		loop 1
		priority 15
		signal 17
	)

	(method (doit)
		(if (not (& (gEgo onControl: 0) $0040))
			(sFX number: 915 play:)
			(drawerInset dispose:)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 21 75) ; "You find a piece of paper with a series of numbers on it..."386.""
				(SetFlag 34)
				(SetScore 171 10)
			)
			(3 ; Do
				(Print 21 76) ; "Carefully you close and relock the drawer."
				(self dispose:)
			)
			(4 ; Inventory
				(switch invItem
					(28 ; noteBook
						(Print 21 77) ; "You jot the numbers down in your notebook."
						(SetFlag 34)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pat of Actor
	(properties
		x 123
		y 159
		lookStr {Your partner, Pat Morales, is an attractive, but tough-looking woman.}
		view 234
		loop 6
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(if (== local1 4)
					(Print 21 78) ; "Pat is busy at her desk right now."
				else
					(HandsOff)
					(gCurRoom setScript: patRandom)
				)
			)
			(3 ; Do
				(Print 21 79) ; "She doesn't want to shake hands, Bonds."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cChair of Prop
	(properties
		x 221
		y 139
		lookStr {The captain's chair.}
		view 234
		loop 5
		signal 16385
	)
)

(instance captain of Actor
	(properties
		x 224
		y 139
		lookStr {Captain Tate runs the Homicide division for L.P.D.}
		view 241
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(switch gDay
					(1
						(HandsOff)
						(gCurRoom setScript: captTalk)
					)
					(2
						(self setScript: 0)
						(HandsOff)
						(gCurRoom setScript: cRTalk)
					)
					(5
						(HandsOff)
						(gCurRoom setScript: capt5Talk)
					)
					(6
						(cond
							((and (IsFlag 174) (not (IsFlag 175)))
								(gCurRoom setScript: turnPatIn)
							)
							((and (not (IsFlag 65)) (not (IsFlag 36)))
								(HandsOff)
								(gCurRoom setScript: lastDay)
							)
							((IsFlag 175)
								(Print 21 80) ; "You've already informed the captain of Morales' activities."
							)
							(else
								(Print 21 81) ; "The captain doesn't have time for idle chit chat."
							)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance captInset of Prop
	(properties
		x 263
		y 188
		view 242
		priority 15
		signal 16400
	)

	(method (init)
		(self stopUpd:)
		(captMouth posn: (- (self x:) 4) (self y:) 56 setCycle: RandCycle init:)
		(super init:)
	)

	(method (dispose)
		(captMouth dispose:)
		(super dispose:)
	)
)

(instance captMouth of Prop
	(properties
		view 242
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyInset of Prop
	(properties
		x 47
		y 122
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(super init:)
		(self stopUpd:)
		(if (>= gDay 2)
			(sonnyShirt posn: (+ (self x:) 3) (+ (self y:) 61) init:)
		)
		(sonnyMouth
			posn: (self x:) (+ (self y:) 20)
			z: 20
			setCycle: RandCycle
			init:
		)
	)

	(method (dispose)
		(sonnyMouth dispose:)
		(sonnyShirt dispose:)
		(super dispose:)
	)
)

(instance sonnyMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyShirt of View
	(properties
		description {Sonny}
		view 25
		cel 1
		priority 15
		signal 16401
	)
)

(instance thisRoom of Feature
	(properties
		x 160
		nsBottom 200
		nsRight 320
		description {sergeant's room}
		lookStr {The homicide room.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (not (gEgo normal:))
					(HandsOff)
					(gCurRoom setScript: standScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance patInset of Prop
	(properties
		x 53
		y 125
		description {Pat Morales}
		view 27
		priority 15
		signal 16401
	)

	(method (init)
		(patMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(patShirt posn: (+ (self x:) 2) (+ (self y:) 62) init: stopUpd:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(patShirt dispose:)
		(super dispose:)
		(patMouth dispose:)
	)
)

(instance patShirt of View
	(properties
		x 53
		y 85
		description {Pat Morales}
		view 27
		cel 1
		priority 15
		signal 16401
	)
)

(instance patMouth of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance note of Prop
	(properties
		x 148
		y 83
		view 234
		loop 4
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(switch gDay
					(3
						(Print 21 82) ; "You have a phone message from the captain in your basket."
					)
					(4
						(cond
							((IsFlag 80)
								(Print 21 83) ; "There is a note in your basket."
							)
							(
								(and
									(not (IsFlag 221))
									(not (IsFlag 80))
									(not (IsFlag 63))
								)
								(Print 21 83) ; "There is a note in your basket."
							)
							((not (IsFlag 28))
								(Print 21 84) ; "There's a subpoena in your basket."
							)
						)
					)
					(5
						(if (IsFlag 31)
							(Print 21 83) ; "There is a note in your basket."
						)
					)
				)
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: noteScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gChair of Prop
	(properties
		x 156
		y 112
		lookStr {A guest chair.}
		view 234
		loop 2
		cel 1
		signal 16385
	)
)

(instance cInset of Prop
	(properties
		x 239
		y 171
		lookStr {It's a computer.}
		view 249
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 21 85) ; "You need your Computer Access card."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(computebutton init:)
		(screen setCycle: End init:)
		(sFX number: 214 play:)
		(card init:)
		(super init:)
	)

	(method (dispose)
		(computebutton dispose:)
		(screen dispose:)
		(card dispose:)
		(super dispose:)
	)
)

(instance computebutton of Prop
	(properties
		x 231
		y 171
		z 7
		lookStr {That's the power switch.}
		view 249
		loop 3
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cInset dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 199
		y 171
		z 56
		lookStr {That's the computer monitor.}
		view 249
		loop 4
		priority 15
		signal 16
		cycleSpeed 11
	)
)

(instance card of Prop
	(properties
		x 251
		y 171
		z 44
		lookStr {That's the computer access card slot.}
		view 249
		loop 5
		priority 15
		signal 16
	)

	(method (cue)
		(gTheIconBar enable: 0)
		(= global114 111)
		(gCurRoom newRoom: 200)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(21 ; compCard
						(sFX number: 702 play:)
						(HandsOff)
						(self setCycle: End self)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFX of Sound
	(properties)
)

(instance eChair of Prop
	(properties
		x 74
		y 101
		description {chair}
		view 234
		loop 2
		cel 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== gDay 1)
					(Print 21 65) ; "The chairs are for officers assigned to Homicide."
				else
					(Print 21 86) ; "That's where Earl sits."
				)
			)
			(3 ; Do
				(if (== gDay 1)
					(Print 21 61) ; "You're not in the homicide division."
				else
					(Print 21 69) ; "Sit in your own chair, Sonny."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance captDesk of Feature
	(properties
		x 212
		y 129
		onMeCheck 256
		lookStr {Captain Tate's desk is well organized - as usual.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 21 87) ; "Messing with Captain Tate could get you fired, Bonds."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance patDesk of Feature
	(properties
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== gDay 1)
					(Print 21 71) ; "The desks are for officers assigned to Homicide."
				else
					(Print 21 88) ; "That desk belongs to Pat Morales - your partner."
				)
			)
			(3 ; Do
				(if (== gDay 1)
					(Print 21 89) ; "You are not assigned to Homicide right now."
				else
					(Print 21 90) ; "There's nothing of interest on Pat's desk."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance earlDesk of Feature
	(properties
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== gDay 1)
					(Print 21 71) ; "The desks are for officers assigned to Homicide."
				else
					(Print 21 91) ; "Earl Hank's desk is cluttered and covered with scuff marks from his shoes."
				)
			)
			(3 ; Do
				(if (== gDay 1)
					(Print 21 89) ; "You are not assigned to Homicide right now."
				else
					(Print 21 92) ; "Leave Earl's stuff alone."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yourDesk of Feature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== gDay 1)
					(Print 21 71) ; "The desks are for officers assigned to Homicide."
				else
					(Print 21 93) ; "Your desk is near the filing cabinet."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance roomWindow of Feature
	(properties
		onMeCheck 8192
		lookStr {The window looks out into the hallway.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 21 94) ; "The window doesn't open and the blinds are fine."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance graphChart of Feature
	(properties
		nsTop 33
		nsLeft 163
		nsBottom 58
		nsRight 194
		lookStr {The graph on the wall charts homicides for the past three years. Like inflation, the crime-rate rises steadily.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 21 95) ; "You can't stop crime by ripping up the graph."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bookCase of Feature
	(properties
		onMeCheck 2048
		lookStr {The bookcase has old paperbacks and phone books in it. Nothing interests you.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 21 96) ; "None of the books interest you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bulletin of Feature
	(properties
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 21 97) ; "The messages are public - leave them up."
			)
			(2 ; Look
				(cond
					((== gDay 5)
						(Print 21 98) ; "The memo advises of a mandatory attendance of all female officers for physical performance testing at the beginning of shift tomorrow."
						(SetScore 161 3)
					)
					((< (Random 0 100) 5)
						(Print 21 99) ; "Herein lies the names of the programmers who without undo fanfare brought you this game. Doug Oldfield, Chris Hoyt, Kim Bowdish, Mike Larsen. and Chris Carr."
					)
					(else
						(Print 21 100) ; "Rarely do you find anything of interest on the bulletin board."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		onMeCheck 4096
		lookStr {The file cabinet belongs to the captain. He always keeps it locked.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 21 72) ; "It's locked."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

