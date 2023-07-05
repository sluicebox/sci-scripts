;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use n001)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro 0
)

(local
	armSpeed
	targState
	smokeCycles
	lookDir
	[lookLoop 3] = [6 2 6]
	[lookCel 3] = [0 2 1]
	[fireData 30] = [4 62 120 3 63 140 2 80 135 5 97 140 4 111 128 4 143 127 4 225 121 2 232 135 3 246 139 5 269 141]
	[theSmoke 10]
	[carpData 33] = [0 167 141 1 176 136 2 178 132 3 180 128 4 180 123 5 180 118 4 182 115 3 184 112 2 187 109 1 195 105 0 208 102]
)

(instance intro of Rm
	(properties
		picture 750
		style 8
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(ClearFlag 2)
		(LoadMany rsSCRIPT 988 969)
		(LoadMany rsPIC 2 780)
		(LoadMany rsVIEW 750 755 758 760 780)
		(LoadMany rsSOUND 750 751 752 753 754 761)
		(super init:)
		(gKeyDownHandler add: self)
		(self setScript: halfD)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			(gCurRoom newRoom: 765) ; notice2Room
			(event claimed: 1)
		else
			(event claimed: 1)
		)
	)
)

(instance head of Actor
	(properties
		x 151
		y 128
		view 755
		loop 2
		priority 2
		signal 30736
		illegalBits 0
	)
)

(instance body of Actor
	(properties
		x 149
		y 145
		view 755
		loop 4
		priority 1
		signal 30736
		illegalBits 0
	)
)

(instance arms of Actor
	(properties
		x 152
		y 73
		view 755
		loop 7
		priority 3
		signal 30736
		illegalBits 0
	)
)

(instance hand1 of Actor
	(properties
		x 114
		y 76
		view 755
		priority 15
		signal 30736
		illegalBits 0
	)
)

(instance hand2 of Actor
	(properties
		x 175
		y 80
		view 755
		loop 1
		priority 15
		signal 30736
		illegalBits 0
	)
)

(instance carpet of Actor
	(properties
		x -10
		y 100
		yStep 3
		view 758
		priority 15
		signal 24592
		cycleSpeed 1
		illegalBits 0
	)
)

(instance sierra of View
	(properties
		x 188
		y 173
		view 750
		priority 12
		signal 30736
	)
)

(instance presents of View
	(properties
		x 190
		y 187
		view 750
		loop 1
		priority 12
		signal 30736
	)
)

(instance halfD of Script
	(properties)

	(method (doit &tmp carpetX oldDir)
		(super doit:)
		(if (== state 20)
			(= carpetX (carpet x:))
			(= oldDir lookDir)
			(cond
				((< carpetX 120)
					(= lookDir 0)
				)
				((> carpetX 250)
					(self cue:)
				)
				((> carpetX 190)
					(= lookDir 2)
				)
				(else
					(= lookDir 1)
				)
			)
			(if (!= oldDir lookDir)
				(head setLoop: [lookLoop lookDir] setCel: [lookCel lookDir])
			)
		)
	)

	(method (changeState newState &tmp [temp0 2] temp2)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= targState 0)
				(SetCursor gTheCursor 0)
				(gCSound number: 750 loop: -1 priority: 0 playBed:)
				(= seconds 3)
			)
			(2
				(hand1 cel: 0 init: cycleSpeed: 2 setCycle: End self)
			)
			(3
				(gMiscSound number: 751 loop: 0 priority: 8 play:)
				(ShakeScreen 3)
				(= seconds 2)
			)
			(4
				(hand1 stopUpd:)
				(hand2 cel: 0 init: cycleSpeed: 2 setCycle: End self)
			)
			(5
				(gMiscSound number: 752 loop: 0 priority: 8 play:)
				(hand2 stopUpd:)
				(ShakeScreen 3)
				(= seconds 2)
			)
			(6
				(switch gHowFast
					(0
						(= armSpeed 1)
						(= temp2 28)
					)
					(1
						(= armSpeed 2)
						(= temp2 14)
					)
					(else
						(= armSpeed 3)
						(= temp2 7)
					)
				)
				(head init: yStep: temp2 setMotion: MoveTo 152 80)
				(body yStep: temp2 init: setMotion: MoveTo 152 96 self)
			)
			(7
				(body setMotion: MoveTo 152 86)
				(head setMotion: MoveTo 152 70)
				(arms setCel: 0 init:)
				(= cycles armSpeed)
			)
			(8
				(arms setCel: 1)
				(body posn: 152 80)
				(head posn: 152 64)
				(= cycles armSpeed)
			)
			(9
				(arms setCel: 2 setPri: 13)
				(body posn: 151 72)
				(head posn: 151 56)
				(hand1 dispose:)
				(hand2 dispose:)
				(= cycles armSpeed)
			)
			(10
				(arms setCel: 3)
				(body posn: 150 63)
				(head posn: 150 47)
				(= cycles armSpeed)
			)
			(11
				(= seconds 2)
			)
			(12
				(body addToPic:)
				(head stopUpd:)
				(arms setLoop: 5 setCel: 0)
				(= cycles 1)
			)
			(13
				(arms setCel: 1)
				(= cycles 1)
			)
			(14
				(gMiscSound number: 753 loop: 0 priority: 8 play: self)
				(arms setCel: 2)
			)
			(15
				(arms setCel: 3)
				(= cycles 1)
			)
			(16
				(gMiscSound number: 753 loop: 0 priority: 8 play: self)
				(arms setCel: 4)
			)
			(17
				(sierra init: addToPic:)
				(presents init: addToPic:)
				(= seconds 2)
			)
			(18
				(arms setLoop: 7 setCel: 3 addToPic:)
				(= seconds 2)
			)
			(19
				(head setCel: 1)
				(= lookDir 2)
				(carpet init: setScript: hdCarp)
				(= cycles 1)
			)
			(20
				(= lookDir 1)
			)
			(21
				(head setLoop: 2 setCel: 2 setCycle: Beg self)
			)
			(22
				(gMiscSound number: 754 loop: 0 priority: 8 play:)
				(self setScript: genLaugh self)
			)
			(23
				(head addToPic:)
				(self dispose:)
			)
		)
	)
)

(instance genLaugh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(head setLoop: 3 setCel: 0 cycleSpeed: 1 setCycle: End self)
				(= register 5)
			)
			(1
				(head setCel: 1)
				(= cycles 2)
			)
			(2
				(head setCel: 2)
				(= cycles 2)
			)
			(3
				(if (-- register)
					(self changeState: 1)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance hdCarp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(carpet setCycle: Fwd setMotion: MoveTo 340 92 self)
			)
			(1
				(gCurRoom setScript: titles)
			)
		)
	)
)

(instance questWord of PicView
	(properties
		x 72
		y 64
		view 760
		priority 5
	)
)

(instance forWord of PicView
	(properties
		x 161
		y 62
		view 760
		cel 1
		priority 5
	)
)

(instance gloryWord of PicView
	(properties
		x 248
		y 66
		view 760
		cel 2
		priority 5
	)
)

(instance twoWord of PicView
	(properties
		x 154
		y 115
		view 760
		cel 3
		priority 0
	)
)

(instance trial of PicView
	(properties
		x 155
		y 175
		view 760
		loop 1
		priority 5
	)
)

(instance bigF of Prop
	(properties
		x 210
		y 171
		view 760
		loop 6
		priority 6
		signal 26640
		cycleSpeed 1
	)
)

(instance titles of Script
	(properties)

	(method (changeState newState &tmp smoker smokeIndex)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(gCurRoom drawPic: 2)
				(questWord init:)
				(forWord init:)
				(gloryWord init:)
				(twoWord init:)
				(trial init:)
				(gAddToPics doit:)
				(= smoker 0)
				(for ((= smokeIndex 0)) (< smoker 10) ((+= smokeIndex 3))
					((= [theSmoke smoker] (Prop new:))
						view: 760
						loop: [fireData smokeIndex]
						cel: (mod smoker 4)
						posn: [fireData (+ smokeIndex 1)] [fireData (+ smokeIndex 2)]
						setPri: 3
						ignoreActors:
						init:
						stopUpd:
					)
					(if (>= gHowFast 2)
						([theSmoke smoker] setCycle: Fwd)
						(= smokeCycles 1)
					else
						([theSmoke smoker] addToPic:)
						(= smokeCycles 0)
					)
					(++ smoker)
				)
				(= seconds 2)
			)
			(1
				(carpet
					posn: -20 108
					init:
					setCycle: Fwd
					setMotion: MoveTo 167 157 self
				)
			)
			(2
				(if smokeCycles
					(= smoker 0)
					(for ((= smokeIndex 0)) (< smoker 10) ((+= smokeIndex 3))
						([theSmoke smoker] setCycle: 0 stopUpd:)
						(++ smoker)
					)
				)
				(gMiscSound number: 761 loop: 0 priority: 10 play:)
				(bigF init: setCycle: Fwd)
				(carpet setLoop: 1)
				(self setScript: carpetDodge self)
			)
			(3
				(bigF dispose:)
				(if smokeCycles
					(= smoker 0)
					(for ((= smokeIndex 0)) (< smoker 10) ((+= smokeIndex 3))
						([theSmoke smoker] setCycle: Fwd)
						(++ smoker)
					)
				)
				(carpet
					setPri: 1
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 340 162 self
				)
			)
			(4
				(gCurRoom newRoom: 770) ; OpeningCredits
			)
		)
	)
)

(instance carpetDodge of Script
	(properties)

	(method (changeState newState &tmp index)
		(if (< (= state newState) 11)
			(= index (* state 3))
			(carpet
				setCel: [carpData index]
				setMotion:
					MoveTo
					[carpData (+ index 1)]
					[carpData (+ index 2)]
					self
			)
		else
			(self dispose:)
		)
	)
)

(instance shapeir of PicView ; UNUSED
	(properties
		x 145
		y 90
		view 780
		loop 2
		priority 0
	)
)

(instance saurusLot of PicView ; UNUSED
	(properties
		x 129
		y 95
		view 780
		loop 3
		priority 1
	)
)

