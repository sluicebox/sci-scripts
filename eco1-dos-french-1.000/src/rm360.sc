;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use Interface)
(use PalCycle)
(use Language)
(use Osc)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm360 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 2] = [48 112]
	local9
	local10
	local11 = 14
	local12
	local13
	local14
	local15
	local16 = 1
	local17
	local18
	local19
	[local20 3]
)

(instance rm360 of Rm
	(properties
		picture 50
		style 100
	)

	(method (init)
		(LoadMany
			rsVIEW
			360
			364
			(proc0_6 1000 2000 3000 4000 40)
			361
			362
			(proc0_6 1956 2956 3956 4956 956)
			363
			342
		)
		(LoadMany rsPIC 360 50 901 320 340)
		(LoadMany rsSOUND 360 398 362)
		(= local6 0)
		(eco1 init: posn: 133 73 setLoop: 1 cel: 0 ignoreActors: 1 hide:)
		(eco2 init: posn: 164 62 setLoop: 0 ignoreActors: 1 cel: 0 hide:)
		(super init: &rest)
		(SetCursor 957 0 9)
		(self setScript: main0)
	)

	(method (doit &tmp [temp0 60] [temp60 20] [temp80 20] [temp100 20])
		(super doit:)
		(SetCursor 957 0 9)
		(MoveCursor 0 0)
		(if (== ((User curEvent:) message:) KEY_F2)
			(return 0)
		)
		(if (OneOf ((User curEvent:) type:) evMOUSEBUTTON evKEYBOARD evJOYDOWN)
			(= local19 1)
		)
		(return
			(if local19
				(proc932_8 99 360 1 @temp0)
				(proc932_8 99 360 2 @temp60)
				(proc932_8 99 360 3 @temp80)
				(proc932_8 99 360 4 @temp100)
				(Sound pause: 1)
				(gGame setCursor: gWaitCursor)
				(MoveCursor 58 120)
				(switch
					(Print
						@temp0
						82
						813
						0
						0
						67
						-1
						60
						106
						81
						@temp60
						2
						106
						81
						@temp80
						0
						106
						81
						@temp100
						1
					)
					(0
						(Sound pause: 0)
						(SetCursor 957 0 9)
					)
					(1
						(Sound pause: 0)
						(gGame restore:)
					)
					(2
						(Sound pause: 0)
						(if (IsObject bubbles)
							(bubbles setScript: 0 hide:)
						)
						(self setScript: leave)
					)
				)
				(= local19 0)
				((User curEvent:) type: evNULL)
			)
		)
	)

	(method (dispose)
		(MoveCursor 300 180)
		(super dispose: &rest)
	)
)

(instance leave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (cycleStuff cyclePal:)
					(cycleStuff cyclePal: 0 restorePal:)
				)
				(gCast eachElementDo: #hide)
				(gLongSong fade: 0 10 4 1)
				(= cycles 1)
			)
			(1
				(gCurRoom drawPic: 901 -32759)
				(= cycles 1)
			)
			(2
				(gGame setCursor: gWaitCursor 1)
				(gCurRoom newRoom: 400)
				(self dispose:)
			)
		)
	)
)

(instance bubbleStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 0)
				(= local9 (* (Random 1 10) 25))
				(gSoundEffects number: 362 loop: 1 play:)
				(bubbles
					startUpd:
					show:
					setCel: 0
					setLoop: 4
					moveSpeed: 4
					posn: local9 168
					setMotion: MoveTo local9 145 self
				)
			)
			(1
				(bubbles setCel: 1 setMotion: MoveTo local9 110 self)
			)
			(2
				(bubbles setCel: 2 setMotion: MoveTo local9 92 self)
			)
			(3
				(bubbles setCel: 3 setMotion: MoveTo local9 40 self)
			)
			(4
				(bubbles setCel: 4 setMotion: MoveTo local9 10 self)
			)
			(5
				(bubbles setCel: 5 setMotion: MoveTo local9 6 self)
			)
			(6
				(bubbles setCel: 6 setMotion: MoveTo local9 -50 self)
			)
			(7
				(= local13 1)
				(= seconds 3)
			)
			(8
				(self changeState: 0)
			)
		)
	)
)

(instance ecoStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin hide:)
				(if (!= (gGame printLang:) 33)
					(eco1 show: posn: 133 74 setCycle: End)
					(eco2 show: posn: 164 62 setCycle: End self)
				else
					(eco1 view: 3364 loop: 0 show: posn: 160 100)
					(self cue:)
				)
			)
			(1
				(if (!= (gGame printLang:) 33)
					(eco1 setLoop: 3 cel: 0 setCycle: End)
					(eco2 setLoop: 2 cel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(= local6 0)
				(self dispose:)
			)
		)
	)
)

(instance main0 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gLongSong number: 360 loop: -1 play:)
				(bubbles
					init:
					ignoreActors: 1
					ignoreHorizon: 1
					setLoop: 4
					setStep: 10 10
					moveSpeed: 2
					setScript: bubbleStuff
				)
				(= local6 2)
				(presents init: hide:)
				(an init: hide:)
				(under init: hide:)
				(adven init: hide:)
				(= ticks 20)
			)
			(2
				(cycleStuff
					cycleInt: 0
					numInt: 1
					cyclePal: 1
					oscInt: 1
					intDir: 3
					init:
					loIntLevel: 50
				)
				(= ticks 120)
			)
			(3
				(presents show: stopUpd:)
				(= ticks 60)
			)
			(4
				(an show: stopUpd:)
				(= ticks 30)
			)
			(5
				(under show: stopUpd:)
				(= ticks 30)
			)
			(6
				(adven show: stopUpd:)
				(= ticks 180)
			)
			(7
				(presents dispose:)
				(an dispose:)
				(under dispose:)
				(adven dispose:)
				(gCurRoom drawPic: 901 -32759)
				(cycleStuff cyclePal: 0 restorePal:)
				(bubbles hide:)
				(= cycles 1)
			)
			(8
				(gCurRoom setScript: main1)
				(self dispose:)
			)
		)
	)
)

(instance main1 of Script
	(properties)

	(method (doit)
		(if (and (== state 1) local13)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gGame printLang:) 33)
					(gCurRoom drawPic: 50 9)
				else
					(gCurRoom drawPic: 360 9)
				)
				(= local6 0)
				(= ticks 10)
			)
			(1
				(cycleStuff savePal: cyclePal: 1)
				(= local10 10)
			)
			(2
				(bubbles setScript: 0)
				(dolphin
					init:
					ignoreActors: 1
					posn: 279 58
					setLoop: 0
					setCel: 0
				)
				(= ticks local10)
			)
			(3
				(dolphin posn: 249 54 setLoop: 0 setCel: 1)
				(= ticks local10)
			)
			(4
				(dolphin posn: 177 49 setLoop: 0 setCel: 2)
				(= ticks local10)
			)
			(5
				(dolphin posn: 135 92 setLoop: 1 setCel: 0)
				(= ticks local10)
			)
			(6
				(dolphin posn: 91 80 setLoop: 1 setCel: 1)
				(= ticks local10)
			)
			(7
				(dolphin posn: 19 69 setLoop: 1 setCel: 2)
				(= ticks local10)
			)
			(8
				(sfx play:)
				(bubbles setScript: bubbleStuff)
				(self setScript: ecoStuff)
				(cycleStuff cyclePal: 1)
				(= ticks 420)
			)
			(9
				(cycleStuff cyclePal: 0 restorePal:)
				(= cycles 3)
			)
			(10
				(eco1 hide:)
				(eco2 hide:)
				(bubbles hide:)
				(gCurRoom setScript: main2)
				(bubbles setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance main2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 execProducer)
				(= local1 ken)
				(self setScript: oceanCredit self)
				(= local3 local0)
				(= local4 local1)
			)
			(1
				(= local0 creatDirector)
				(= local1 billD)
				(self setScript: dolphinCredit self)
				(= local3 local0)
				(= local4 local1)
			)
			(2
				(bubbles setScript: 0 hide:)
				(= local0 director)
				(= local1 billS)
				(self setScript: oceanCredit self)
				(= local3 local0)
				(= local4 local1)
			)
			(3
				(= local0 producer)
				(= local1 tammy)
				(self setScript: dolphinCredit self)
				(= local3 local0)
				(= local4 local1)
			)
			(4
				(= local0 gameDesign)
				(= local1 gano)
				(= local2 jane)
				(self setScript: dolphinCredit2 self)
				(= local3 local0)
				(= local4 local1)
				(= local5 local2)
			)
			(5
				(= local0 artDesign)
				(= local1 billS2)
				(self setScript: dolphinCredit3 self)
				(= local3 local0)
				(= local4 local1)
			)
			(6
				(= local0 leadProgram)
				(= local1 jerry)
				(self setScript: dolphinCredit2 self)
				(= local3 local0)
				(= local4 local1)
			)
			(7
				(bubbles setScript: 0 hide:)
				(= local0 composer)
				(= local1 chris)
				(self setScript: oceanCredit self)
				(= local3 local0)
				(= local4 local1)
			)
			(8
				(Load rsSOUND 361)
				(self setScript: dolphinNoCredit self)
			)
			(9
				(bubbles setScript: 0 hide:)
				(self setScript: oceanNoCredit self)
			)
			(10
				(self setScript: dolphinNet self)
			)
			(11
				(gGame setCursor: gWaitCursor 1)
				(gLongSong fade: 0 10 4 1)
				(gCurRoom newRoom: 400)
				(self dispose:)
			)
		)
	)
)

(instance oceanCredit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 398)
				(if (IsObject local3)
					(local3 dispose:)
				)
				(if (IsObject local4)
					(local4 dispose:)
				)
				(gCurRoom drawPic: 320 9)
				(= cycles 1)
			)
			(1
				(eco1 setScript: credit)
				(dolphin
					show:
					view: 361
					setLoop: 2
					setCel: 0
					posn: 157 82
					setCycle: CT 7 1 self
				)
			)
			(2
				(gSoundEffects number: 398 play:)
				(dolphin setCycle: End self)
			)
			(3
				(dolphin hide:)
				(= ticks 180)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance dolphinCredit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3 dispose:)
				(local4 dispose:)
				(gCurRoom drawPic: 340 9)
				(= cycles 1)
			)
			(1
				(bubbles setScript: bubbleStuff)
				(eco1 setScript: credit)
				(dolphin show: view: 362 setLoop: 0 setCel: 0 posn: 319 86)
				(= ticks local11)
			)
			(2
				(dolphin setLoop: 0 setCel: 1 posn: 296 88)
				(= ticks local11)
			)
			(3
				(dolphin setLoop: 0 setCel: 2 posn: 272 95)
				(= ticks local11)
			)
			(4
				(dolphin setLoop: 0 setCel: 3 posn: 230 104)
				(= ticks local11)
			)
			(5
				(dolphin setLoop: 0 setCel: 4 posn: 193 97)
				(= ticks local11)
			)
			(6
				(dolphin setLoop: 0 setCel: 0 posn: 157 87)
				(= ticks local11)
			)
			(7
				(dolphin setLoop: 0 setCel: 1 posn: 128 89)
				(= ticks local11)
			)
			(8
				(dolphin setLoop: 0 setCel: 2 posn: 96 95)
				(= ticks local11)
			)
			(9
				(dolphin setLoop: 0 setCel: 3 posn: 62 100)
				(= ticks local11)
			)
			(10
				(dolphin setLoop: 0 setCel: 4 posn: 37 92)
				(= ticks local11)
			)
			(11
				(dolphin setLoop: 0 setCel: 0 posn: 0 86)
				(= ticks local11)
			)
			(12
				(dolphin hide:)
				(= ticks 180)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance dolphinCredit2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3 dispose:)
				(local4 dispose:)
				(= cycles 1)
			)
			(1
				(dolphin show: view: 361 setLoop: 1 setCel: 0 posn: 310 180)
				(= ticks local11)
			)
			(2
				(dolphin setLoop: 1 setCel: 1 posn: 291 166)
				(= ticks local11)
			)
			(3
				(dolphin setLoop: 1 setCel: 2 posn: 262 155)
				(= ticks local11)
			)
			(4
				(dolphin setLoop: 1 setCel: 3 posn: 233 134)
				(= ticks local11)
			)
			(5
				(dolphin setLoop: 1 setCel: 4 posn: 209 115)
				(= ticks local11)
			)
			(6
				(dolphin setLoop: 1 setCel: 0 posn: 172 89)
				(= ticks local11)
			)
			(7
				(dolphin setLoop: 1 setCel: 1 posn: 156 77)
				(= ticks local11)
			)
			(8
				(dolphin setLoop: 1 setCel: 2 posn: 126 69)
				(if (== local1 jerry)
					(self setScript: credit)
				else
					(self setScript: credit2)
				)
				(= ticks local11)
			)
			(9
				(dolphin setLoop: 1 setCel: 3 posn: 92 45)
				(= ticks local11)
			)
			(10
				(dolphin setLoop: 1 setCel: 4 posn: 62 31)
				(= ticks local11)
			)
			(11
				(dolphin setLoop: 1 setCel: 1 posn: 16 -1)
				(= ticks local11)
			)
			(12
				(dolphin hide:)
				(= ticks 180)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance dolphinCredit3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3 dispose:)
				(local4 dispose:)
				(local5 dispose:)
				(= cycles 1)
			)
			(1
				(dolphin show: view: 361 setLoop: 0 setCel: 0 posn: 164 189)
				(= ticks local11)
			)
			(2
				(dolphin setLoop: 0 setCel: 1 posn: 164 171)
				(= ticks local11)
			)
			(3
				(dolphin setLoop: 0 setCel: 2 posn: 165 147)
				(= ticks local11)
			)
			(4
				(dolphin setLoop: 0 setCel: 3 posn: 164 126)
				(= ticks local11)
			)
			(5
				(dolphin setLoop: 0 setCel: 4 posn: 164 111)
				(= ticks local11)
			)
			(6
				(dolphin setLoop: 0 setCel: 0 posn: 164 92)
				(= ticks local11)
			)
			(7
				(dolphin setLoop: 0 setCel: 1 posn: 164 73)
				(= ticks local11)
			)
			(8
				(dolphin setLoop: 0 setCel: 1 posn: 163 57)
				(self setScript: credit)
				(= ticks local11)
			)
			(9
				(dolphin setLoop: 0 setCel: 2 posn: 163 40)
				(= ticks local11)
			)
			(10
				(dolphin setLoop: 0 setCel: 3 posn: 163 15)
				(= ticks local11)
			)
			(11
				(dolphin setLoop: 0 setCel: 4 posn: 163 -10)
				(= ticks local11)
			)
			(12
				(dolphin hide:)
				(= ticks 180)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance dolphinNoCredit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3 dispose:)
				(local4 dispose:)
				(gCurRoom drawPic: 340 9)
				(= cycles 1)
			)
			(1
				(bubbles setScript: bubbleStuff)
				(dolphin show: view: 361 setLoop: 1 setCel: 0 posn: 310 180)
				(= ticks local11)
			)
			(2
				(dolphin setLoop: 1 setCel: 1 posn: 291 166)
				(= ticks local11)
			)
			(3
				(dolphin setLoop: 1 setCel: 2 posn: 262 155)
				(= ticks local11)
			)
			(4
				(dolphin setLoop: 1 setCel: 3 posn: 233 134)
				(= ticks local11)
			)
			(5
				(dolphin setLoop: 1 setCel: 4 posn: 209 115)
				(= ticks local11)
			)
			(6
				(dolphin setLoop: 1 setCel: 0 posn: 172 89)
				(= ticks local11)
			)
			(7
				(dolphin setLoop: 1 setCel: 1 posn: 156 77)
				(= ticks local11)
			)
			(8
				(dolphin setLoop: 1 setCel: 2 posn: 126 69)
				(= ticks local11)
			)
			(9
				(dolphin setLoop: 1 setCel: 3 posn: 92 45)
				(= ticks local11)
			)
			(10
				(dolphin setLoop: 1 setCel: 4 posn: 62 31)
				(= ticks local11)
			)
			(11
				(dolphin setLoop: 1 setCel: 1 posn: 16 -1)
				(= ticks local11)
			)
			(12
				(dolphin hide:)
				(= cycles 1)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance oceanNoCredit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 320 9)
				(= cycles 1)
			)
			(1
				(dolphin
					show:
					view: 361
					setLoop: 2
					setCel: 0
					posn: 157 82
					setCycle: CT 7 1 self
				)
			)
			(2
				(gSoundEffects number: 398 play:)
				(dolphin setCycle: End self)
			)
			(3
				(dolphin hide:)
				(= ticks 120)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance dolphinNet of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(local16
				(net posn: (Random 148 149) (Random 68 69))
			)
			(local18
				(dolphin posn: (+ (net x:) 7) (+ (net y:) 8))
			)
			(local17
				(dolphin posn: (+ (net x:) 7) (+ (net y:) 8))
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local11 7)
				(= local14 1)
				(net init: setCel: 0)
				(gCurRoom drawPic: 340 9)
				(= cycles 1)
			)
			(1
				(= ticks 300)
			)
			(2
				(= local14 0)
				(= ticks 60)
			)
			(3
				(= local15 1)
				(dolphin show: view: 342 setLoop: 0 setCel: 0 posn: 287 -10)
				(= ticks local11)
			)
			(4
				(dolphin setLoop: 0 setCel: 1 posn: 245 13)
				(= ticks local11)
			)
			(5
				(dolphin setLoop: 0 setCel: 3 posn: 225 36)
				(= ticks local11)
			)
			(6
				(dolphin setLoop: 0 setCel: 2 posn: 191 61)
				(= ticks local11)
			)
			(7
				(gLongSong number: 361 loop: 1 play:)
				(= local16 0)
				(dolphin setLoop: 1 setCel: 1 posn: 166 87 setCycle: CT 5 1)
				(net setLoop: 0 cycleSpeed: 12 setCycle: End self)
			)
			(8
				(dolphin
					setMotion: MoveTo (- (dolphin x:) 16) (+ (dolphin y:) 8)
				)
				(net setMotion: MoveTo (- (net x:) 16) (+ (net y:) 8) self)
			)
			(9
				(= local18 1)
				(net moveSpeed: 9 setMotion: MoveTo (+ (net x:) 25) 25)
				(dolphin cycleSpeed: 12 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(10
				(dolphin setCycle: CT 3 -1 self)
			)
			(11
				(dolphin cycleSpeed: 12 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(12
				(= ticks (Random 10 90))
			)
			(13
				(if (and (< (net y:) 27) (== (gLongSong prevSignal:) 10))
					(= cycles 1)
				else
					(dolphin setCycle: CT 3 -1)
					(-= state 3)
					(= cycles 1)
				)
			)
			(14
				(dolphin setCycle: End self)
			)
			(15
				(if (== (gLongSong prevSignal:) -1)
					(= cycles 1)
				else
					(-= state 1)
					(= cycles 1)
				)
			)
			(16
				(gCast eachElementDo: #hide)
				(gCurRoom style: -32759 drawPic: 901)
				(self dispose:)
			)
		)
	)
)

(instance credit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0
					x: 160
					view: (proc0_6 1956 2956 3956 956 956)
					init:
					stopUpd:
				)
				(local1
					x: 160
					view: (proc0_6 1956 2956 3956 956 956)
					init:
					stopUpd:
				)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance credit2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0
					x: 160
					view: (proc0_6 1956 2956 3956 956 956)
					init:
					stopUpd:
				)
				(local1
					x: 160
					view: (proc0_6 1956 2956 3956 956 956)
					init:
					stopUpd:
				)
				(local2
					x: 160
					view: (proc0_6 1956 2956 3956 956 956)
					init:
					stopUpd:
				)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance dolphin of Actor
	(properties
		view 360
		priority 14
		signal 16400
	)
)

(instance cycleStuff of PalCycle
	(properties)

	(method (palCycle)
		(switch local6
			(0
				(Palette palANIMATE 128 176 3)
			)
			(1
				(Palette palANIMATE 128 176 1 48 96 1)
			)
			(2
				(Palette palANIMATE 64 111 4)
			)
		)
	)

	(method (atInt param1)
		(= intLo [local7 param1])
		(= intHi [local7 (+ param1 1)])
	)
)

(instance eco1 of Prop
	(properties
		view 364
		cycleSpeed 8
	)
)

(instance eco2 of Prop
	(properties
		view 364
		cycleSpeed 8
	)
)

(instance bubbles of Actor
	(properties
		view 364
		loop 4
		signal 16384
	)
)

(instance presents of View
	(properties
		x 160
		y 56
		view 40
		signal 16384
	)

	(method (init)
		(= view (proc0_6 1000 2000 3000 4000 40))
		(super init: &rest)
	)
)

(instance an of View
	(properties
		x 160
		y 89
		view 40
		loop 1
		signal 16384
	)

	(method (init)
		(= view (proc0_6 1000 2000 3000 4000 40))
		(super init: &rest)
	)
)

(instance under of View
	(properties
		x 160
		y 119
		view 40
		loop 2
		signal 16384
	)

	(method (init)
		(= view (proc0_6 1000 2000 3000 4000 40))
		(super init: &rest)
	)
)

(instance adven of View
	(properties
		x 160
		y 149
		view 40
		loop 3
		signal 16384
	)

	(method (init)
		(= view (proc0_6 1000 2000 3000 4000 40))
		(super init: &rest)
	)
)

(instance execProducer of View
	(properties
		x 82
		y 99
		view 956
		priority 1
		signal 16400
	)
)

(instance ken of View
	(properties
		x 90
		y 116
		view 956
		cel 1
		priority 1
		signal 16400
	)
)

(instance creatDirector of View
	(properties
		x 87
		y 47
		view 956
		cel 2
		priority 1
		signal 16400
	)
)

(instance billD of View
	(properties
		x 107
		y 66
		view 956
		cel 3
		priority 1
		signal 16400
	)
)

(instance director of View
	(properties
		x 129
		y 90
		view 956
		cel 4
		priority 1
		signal 16400
	)
)

(instance billS of View
	(properties
		x 55
		y 108
		view 956
		cel 5
		priority 1
		signal 16400
	)
)

(instance producer of View
	(properties
		x 128
		y 46
		view 956
		cel 6
		priority 1
		signal 16400
	)
)

(instance tammy of View
	(properties
		x 77
		y 63
		view 956
		cel 7
		priority 1
		signal 16400
	)
)

(instance gameDesign of View
	(properties
		x 100
		y 49
		view 956
		loop 1
		priority 1
		signal 16400
	)
)

(instance gano of View
	(properties
		x 104
		y 65
		view 956
		loop 1
		cel 1
		priority 1
		signal 16400
	)
)

(instance jane of View
	(properties
		x 99
		y 87
		view 956
		loop 1
		cel 2
		priority 1
		signal 16400
	)
)

(instance artDesign of View
	(properties
		x 116
		y 51
		view 956
		loop 1
		cel 3
		priority 1
		signal 16400
	)
)

(instance billS2 of View
	(properties
		x 59
		y 65
		view 956
		loop 1
		cel 4
		priority 1
		signal 16400
	)
)

(instance leadProgram of View
	(properties
		x 92
		y 46
		view 956
		loop 1
		cel 5
		priority 1
		signal 16400
	)
)

(instance jerry of View
	(properties
		x 99
		y 64
		view 956
		loop 1
		cel 6
		priority 1
		signal 16400
	)
)

(instance composer of View
	(properties
		x 125
		y 99
		view 956
		loop 1
		cel 7
		priority 1
		signal 16400
	)
)

(instance chris of View
	(properties
		x 80
		y 114
		view 956
		loop 1
		cel 8
		priority 1
		signal 16400
	)
)

(instance net of Actor
	(properties
		x 148
		y 68
		view 363
	)
)

(instance dolphinOsc of Osc ; UNUSED
	(properties)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) 5) (< temp0 3))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 1
		number 362
	)
)

