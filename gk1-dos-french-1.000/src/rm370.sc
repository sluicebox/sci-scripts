;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use n013)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm370 0
)

(local
	local0
	local1
	local2
)

(instance rm370 of Room
	(properties
		picture 370
		style 14
		exitStyle 13
	)

	(method (init)
		(gGame handsOff:)
		(ClearFlag 220)
		(= local1 (gGame setCursor:))
		(gGame setCursor: myInvisCursor 1)
		(SetFlag 220)
		(super init:)
		(gGame handsOff:)
		(= gWaitCursor myInvisCursor)
		(dayNumber setCel: 0 setLoop: gDay)
		(if (IsFlag 15)
			(cond
				((== gPrevRoomNum 372)
					(gCurRoom setScript: startTheDay)
				)
				((== gDay 3)
					(if (IsFlag 305)
						(dayNumber setCel: 0 setLoop: 4)
						(ClearFlag 10)
						(ClearFlag 15)
						(++ gDay)
						(gCurRoom setScript: startTheDay)
					else
						(gCurRoom setScript: day3MaliaStuff)
					)
				)
				((== gDay 4)
					(gCurRoom setScript: phoneCall)
				)
				((== gDay 5)
					(gCurRoom setScript: day5MaliaCall)
				)
				((or (== gPrevRoomNum 200) (== gPrevRoomNum 205))
					(gCurRoom setScript: phoneCall)
				)
				(else
					(PalVary 0 370 0) ; PalVaryStart
					(gCurRoom setScript: graceComeOut)
				)
			)
		else
			(gCurRoom setScript: startTheDay)
		)
		(gGkMusic1
			number: 3740
			setLoop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 5 25 0
		)
		(ClearFlag 220)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(= gWaitCursor local1)
		(ClearFlag 220)
		(gGame setCursor: gWaitCursor 1)
		(PalVary 3) ; PalVaryKill
		(super dispose:)
	)
)

(instance graceComeOut of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE))
			(ClearFlag 220)
			(gGame setCursor: myArrowCursor 1)
			(if (SkipSceneDialog)
				(gMessager caller: 0)
				(gMessager killed: 1)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(if (grace cycler:)
					(grace setCycle: 0)
				)
				(self changeState: 99)
				(return 1)
			else
				(gGame setCursor: myInvisCursor 1)
				(return 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorAndWindows init:)
				(farWindow init:)
				(nearWindow init:)
				(bike init:)
				(PalVary 0 370 0) ; PalVaryStart
				(= cycles 1)
			)
			(1
				(gKeyDownHandler add: self)
				(grace init: setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(grace setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(grace
					setCel: 0
					setLoop: 3
					posn: 46 130
					setCycle: Walk
					setMotion: MoveTo 18 167 self
				)
			)
			(4
				(PalVary 1 6 0 1) ; PalVaryReverse
				(= seconds 7)
				(gKeyDownHandler delete: self)
			)
			(5
				(ClearFlag 15)
				(++ gDay)
				(= seconds 3)
			)
			(6
				(dayNumber setCel: 0 setLoop: gDay)
				(ClearFlag 10)
				(PalVary 3) ; PalVaryKill
				(if (OneOf gDay 2 3 6)
					(gCurRoom exitStyle: 0)
					(gCurRoom newRoom: 371)
				else
					(self setScript: startTheDay)
				)
			)
			(99
				(gKeyDownHandler delete: self)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local2 100)) (>= local2 0) ((-= local2 1))
					(Palette 2 0 255 local2) ; PalIntensity
				)
				(= cycles 15)
			)
			(100
				(PalVary 3) ; PalVaryKill
				(gGame setCursor: myInvisCursor 1)
				(grace hide:)
				(= cycles 1)
			)
			(101
				(for ((= local2 0)) (<= local2 100) ((+= local2 1))
					(Palette 2 0 255 local2) ; PalIntensity
				)
				(ClearFlag 15)
				(++ gDay)
				(dayNumber setCel: 0 setLoop: gDay)
				(= cycles 2)
			)
			(102
				(grace setScript: startTheDay)
				(self dispose:)
			)
		)
	)
)

(instance afterTheMaliaScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bike init:)
				(malia
					view: 374
					setCel: 0
					setLoop: 0
					posn: 39 125
					init:
					setPri: 121
					setCycle: End self
				)
			)
			(1
				(malia
					setLoop: 1 1
					cel: 0
					posn: 41 128
					setCycle: Fwd
					setMotion: MoveTo 90 109 self
				)
			)
			(2
				(malia loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(malia dispose:)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance startTheDay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gDay 6)
					(ClearFlag 9)
				)
				(if (!= gDay 4)
					(doorAndWindows init:)
					(farWindow init:)
					(nearWindow init:)
				)
				(if (!= gDay 5)
					(bike init:)
				)
				(if (IsFlag 464)
					(for ((= local2 0)) (<= local2 100) ((+= local2 1))
						(Palette 2 0 255 local2) ; PalIntensity
					)
					(ClearFlag 464)
				)
				(= cycles 1)
			)
			(1
				(gGkSound1 number: 375 setLoop: 1 play:)
				(PalVary 0 370 6) ; PalVaryStart
				(= seconds 7)
			)
			(2
				(if (== (gGame printLang:) 49)
					(dayNumber init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(3
				(if (== (gGame printLang:) 49)
					(dayPeriod init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(4
				(day init: setCycle: End self)
			)
			(5
				(if (== (gGame printLang:) 49)
					(self cue:)
				else
					(dayNumber init: setCycle: End self)
				)
			)
			(6
				(= seconds 3)
			)
			(7
				(switch gDay
					(1
						(gMessager say: 1 0 3 0 self) ; "I dreamt of blood upon the shore, of eyes that spoke of sin. The lake was smooth and deep and black, as was her scented skin...."
					)
					(2
						(gMessager say: 1 0 7 0 self) ; "A mask I wore as I approached, I was what I am not. And though the pattern was unclear, its meaning could be bought...."
					)
					(3
						(gMessager say: 1 0 11 0 self) ; "Drawn to Bacchus's abode, I sought there to conspire. But it was in the city of the dead that I found my heart's desire...."
					)
					(4
						(gMessager say: 1 0 15 0 self) ; "I spoke to one who smelled of death, he gave to me his ears. And crosses that were marked were made into a veil of tears...."
					)
					(5
						(gMessager say: 1 0 20 0 self) ; "The road was blocked, the truth was shunned,   the white flag had been waved.  Reversal cost me all I had, and everything I'd braved...."
					)
					(6
						(gMessager say: 1 0 22 0 self) ; "And then the night became as day, I glimpsed nature's   reddest claw!  The face of fear looked back at me as I gazed into the maw...."
					)
					(7
						(gMessager say: 1 0 24 0 self) ; "My last ally laid to waste, I ran towards the light. I prayed for one to change my path, to give me strength to fight...."
					)
				)
			)
			(8
				(day dispose:)
				(dayNumber dispose:)
				(dayPeriod dispose:)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(= cycles 5)
			)
			(9
				(if (== gDay 4)
					(self setScript: afterTheMaliaScene self)
				else
					(= cycles 1)
				)
			)
			(10
				(gGkSound1 number: 371 setLoop: 1 play:)
				(kidOnBike init: cycleSpeed: 12 setCycle: CT 8 1 self)
			)
			(11
				(gGkSound2 number: 372 setLoop: 1 play:)
				(kidOnBike loop: 0 cel: 9 setCycle: End self)
			)
			(12
				(paper init:)
				(gGkSound1 stop:)
				(kidOnBike dispose:)
				(grace
					view: 372
					setCel: 0
					setLoop: 1 1
					init:
					show:
					posn: 18 167
					setCycle: Walk
					setMotion: MoveTo 48 129 self
				)
			)
			(13
				(grace setCel: 0 setLoop: 2 posn: 39 125 setCycle: End self)
			)
			(14
				(paper dispose:)
				(grace setCel: 0 setLoop: 3 setCycle: End self)
			)
			(15
				(gGkSound1 number: 373 setLoop: 1 play:)
				(grace setCel: 0 setLoop: 4 setCycle: End self)
			)
			(16
				(doorAndWindows dispose:)
				(gGkSound2 number: 374 setLoop: 1 play: self)
			)
			(17
				(if (!= gDay 7)
					(gCurRoom newRoom: 210) ; bookstore
				else
					(ClearFlag 10)
					(gCurRoom newRoom: 220)
				)
			)
		)
	)
)

(instance day3MaliaStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 370
					setCel: 0
					setLoop: 0
					init:
					posn: 128 130
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(gEgo setCel: 0 setLoop: 1 posn: 86 137 setCycle: End self)
			)
			(2
				(bike init:)
				(gEgo
					setCel: 0
					setLoop: 3
					posn: 58 127
					setPri: 140
					setCycle: End self
				)
			)
			(3
				(gEgo setCel: 0 setLoop: 4 setCycle: CT 2 1 self)
			)
			(4
				(gGkSound1 number: 373 setLoop: 1 play:)
				(gEgo setCel: 3 setLoop: 4 setCycle: End self)
			)
			(5
				(gGkSound2 number: 374 setLoop: 1 play:)
				(gEgo hide:)
				(= seconds 4)
			)
			(6
				(gGkSound1 number: 373 setLoop: 1 play:)
				(grace
					init:
					setCel: 0
					setLoop: 0
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(7
				(gGkSound2 number: 374 setLoop: 1 play:)
				(grace setCel: 0 setLoop: 1 setCycle: End self)
			)
			(8
				(malia
					view: 373
					setCel: 0
					setLoop: 0
					init:
					ignoreActors: 1
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(9
				(malia
					setCel: 0
					setLoop: 1 1
					posn: 88 108
					setCycle: Walk
					setMotion: MoveTo 48 133 self
				)
			)
			(10
				(gMessager sayRange: 1 0 10 1 6 self) ; "(DISMISSIVE)Excuse me. I'm going inside."
				(malia setCel: 0 setLoop: 2 posn: 31 130 setCycle: End self)
			)
			(11)
			(12
				(gMessager say: 1 0 10 7 self) ; "(WARNING TONE, THEN PATRONIZING)Gracie.... Say good night."
				(gGkSound1 number: 373 setLoop: 1 play:)
				(malia setCel: 0 setLoop: 3 posn: 39 125 setCycle: End self)
			)
			(13)
			(14
				(gMessager say: 1 0 10 8) ; "(PISSED--STOMPS HER FOOT)OOH!"
				(gGkSound2 number: 374 setLoop: 1 play:)
				(grace hide:)
				(malia setCel: 0 setLoop: 4 posn: 39 125 setCycle: End self)
			)
			(15
				(= cycles 4)
			)
			(16
				(gCurRoom newRoom: 210) ; bookstore
			)
		)
	)
)

(instance day5MaliaCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 210) ; bookstore
					(bike init:)
					(self changeState: 6)
				else
					(gEgo
						view: 370
						setCel: 0
						setLoop: 0
						init:
						posn: 128 130
						cycleSpeed: 10
						setCycle: End self
					)
				)
			)
			(1
				(gEgo setCel: 0 setLoop: 1 posn: 86 137 setCycle: End self)
			)
			(2
				(bike init:)
				(gEgo
					setCel: 0
					setLoop: 3
					posn: 58 127
					setPri: 140
					setCycle: End self
				)
			)
			(3
				(gEgo setCel: 0 setLoop: 4 setCycle: CT 2 1 self)
			)
			(4
				(gGkSound1 number: 373 setLoop: 1 play:)
				(gEgo setCel: 3 setLoop: 4 setCycle: End self)
			)
			(5
				(gGkSound2 number: 374 setLoop: 1 play:)
				(gEgo hide:)
				(= seconds 4)
			)
			(6
				(gGkSound1 number: 373 setLoop: 1 play:)
				(grace
					init:
					setCel: 0
					setLoop: 0
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(7
				(gGkSound2 number: 374 setLoop: 1 play:)
				(grace setCel: 0 setLoop: 1 setCycle: End self)
			)
			(8
				(grace
					setCel: 0
					setLoop: 3
					posn: 46 130
					setCycle: Walk
					setMotion: MoveTo 18 167 self
				)
			)
			(9
				(self setScript: phoneSounds self)
			)
			(10
				(gGkSound1 number: 2216 setLoop: -1 play:)
				(= seconds 6)
			)
			(11
				(gGkSound1 stop:)
				(= ticks 10)
			)
			(12
				(gMessager say: 1 0 19 1 self) ; "(RRCC. UPSET, FRUSTRATED)Damn!"
			)
			(13
				(= cycles 10)
			)
			(14
				(for ((= local2 100)) (>= local2 0) ((-= local2 1))
					(Palette 2 0 255 local2) ; PalIntensity
				)
				(= cycles 15)
			)
			(15
				(ClearFlag 10)
				(ClearFlag 15)
				(++ gDay)
				(= seconds 3)
			)
			(16
				(SetFlag 464)
				(dayNumber setCel: 0 setLoop: 6)
				(gCurRoom exitStyle: 0)
				(gCurRoom newRoom: 371)
			)
		)
	)
)

(instance phoneCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 210) ; bookstore
					(bike init:)
					(self changeState: 6)
				else
					(gEgo
						view: 370
						loop: 0
						cel: 0
						init:
						posn: 128 130
						cycleSpeed: 10
						setCycle: End self
					)
				)
			)
			(1
				(gEgo
					posn: 86 137
					loop: 1
					cel: 0
					setPri: 138
					setCycle: End self
				)
			)
			(2
				(bike init:)
				(gEgo posn: 58 127 loop: 3 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(gGkSound1 number: 373 setLoop: 1 play:)
				(gEgo loop: 4 cel: 3 setPri: -1 setCycle: End self)
			)
			(5
				(gGkSound2 number: 374 setLoop: 1 play:)
				(gEgo hide:)
				(= seconds 4)
			)
			(6
				(gGkSound1 number: 373 setLoop: 1 play:)
				(grace init: loop: 0 cel: 0 cycleSpeed: 11 setCycle: End self)
			)
			(7
				(gGkSound2 number: 374 setLoop: 1 play:)
				(grace loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(grace loop: 2 cel: 0 setCycle: End self)
			)
			(9
				(grace
					posn: 46 130
					loop: 3
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 18 167 self
				)
			)
			(10
				(grace dispose:)
				(if (== gDay 4)
					(self setScript: phoneSounds self)
				else
					(= cycles 1)
				)
			)
			(11
				(if (== gDay 4)
					(gMessager say: 1 0 14 0 self) ; "(ANSWERING PHONE. LOW. SEXY.)Hello?"
				else
					(= cycles 1)
				)
			)
			(12
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local2 100)) (>= local2 0) ((-= local2 1))
					(Palette 2 0 255 local2) ; PalIntensity
				)
				(= cycles 5)
			)
			(13
				(bike dispose:)
				(ClearFlag 10)
				(ClearFlag 15)
				(++ gDay)
				(= cycles 15)
			)
			(14
				(cond
					((OneOf gDay 2 3)
						(gCurRoom newRoom: 371)
					)
					((IsFlag 470)
						(gGkSound1 number: 202 setLoop: 1 play: self)
					)
					(else
						(self cue:)
					)
				)
			)
			(15
				(if (IsFlag 470)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(16
				(if (and (== gDay 5) (not (IsFlag 470)))
					(gCurRoom exitStyle: 0)
					(gCurRoom newRoom: 372)
				else
					(for ((= local2 0)) (<= local2 100) ((+= local2 1))
						(Palette 2 0 255 local2) ; PalIntensity
					)
					(= cycles 1)
				)
			)
			(17
				(dayNumber setCel: 0 setLoop: gDay)
				(self setScript: startTheDay)
			)
		)
	)
)

(instance phoneSounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGkSound1 number: 2215 setLoop: 1 play: self)
			)
			(1
				(gGkSound1 number: 2205 setLoop: 1 play: self)
			)
			(2
				(gGkSound1 number: 2205 setLoop: 1 play: self)
			)
			(3
				(gGkSound1 number: 2205 setLoop: 1 play: self)
			)
			(4
				(gGkSound1 number: 2201 setLoop: 1 play: self)
			)
			(5
				(gGkSound1 number: 2202 setLoop: 1 play: self)
			)
			(6
				(gGkSound1 number: 2203 setLoop: 1 play: self)
			)
			(7
				(gGkSound1 number: 2204 setLoop: 1 play: self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance grace of Actor
	(properties
		x 39
		y 125
		view 371
	)
)

(instance malia of Actor
	(properties
		x 73
		y 81
		view 373
	)
)

(instance kidOnBike of Prop
	(properties
		x 68
		y 116
		view 372
	)
)

(instance day of Prop
	(properties
		x 76
		y 68
		view 375
	)

	(method (init)
		(= x (proc13_6 136 76 45 76 76))
		(= y (proc13_6 58 68 50 68 68))
		(super init:)
		(self setPri: 255)
	)
)

(instance dayNumber of Prop
	(properties
		x 88
		y 115
		view 375
		loop 1
	)

	(method (init)
		(= x (proc13_6 88 88 250 88 88))
		(= y (proc13_6 115 115 52 115 115))
		(super init:)
		(self setPri: 160)
	)
)

(instance dayPeriod of Prop
	(properties
		x 90
		y 115
		view 375
		loop 11
	)

	(method (init)
		(super init: &rest)
		(self setPri: 160)
	)
)

(instance bike of View
	(properties
		x 86
		y 137
		view 370
		loop 2
	)
)

(instance paper of View
	(properties
		x 38
		y 127
		view 372
		loop 5
	)
)

(instance doorAndWindows of View
	(properties
		x 47
		y 118
		view 377
	)

	(method (init)
		(super init:)
		(self setPri: 120)
	)
)

(instance farWindow of View
	(properties
		x 164
		y 64
		view 377
		loop 1
	)
)

(instance nearWindow of View
	(properties
		x 302
		y 142
		view 377
		loop 2
	)
)

(instance myInvisCursor of Cursor
	(properties
		view 996
	)
)

(instance myArrowCursor of Cursor
	(properties
		view 999
	)
)

