;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm040 0
)

(instance rm040 of PQRoom
	(properties
		picture 40
	)

	(method (init)
		(LoadMany rsVIEW 4 425 426 427 428 429)
		(ClearFlag 85)
		(gEgo
			view: 425
			loop: 0
			cel: 0
			x: 200
			y: 132
			normal: 0
			priority: 8
			signal: 16
			setStep: 3 2
			init:
		)
		(if (and (!= ((gInventory at: 5) owner:) 36) (not (gEgo has: 5))) ; musicBox, musicBox
			(musicBox init:)
		)
		(if (== gDay 1)
			(self picture: 38)
			(gEgo hide:)
			(musicBox hide:)
			(carFront init:)
			(carMid init:)
			(carBack init:)
			(carDoor init: stopUpd: setPri: 15)
		)
		(super init:)
		(dresser init:)
		(bed init:)
		(phone init:)
		(nightStand init:)
		(rm40window init:)
		(readingArea init:)
		(furnishings init:)
		(chair init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 140 161 140 189 166 189 166 162 254 162 254 135 238 128 236 126 184 143 131 118 193 94 178 88 171 83 151 77 140 77 121 83 118 89 107 101 60 115 60 152 80 149 138 149
					yourself:
				)
		)
		(++ gDay)
		(SetFlag 17)
		(HandsOff)
		(if (== gDay 2)
			(gCurRoom setScript: egoPhoneInBed)
		else
			(gCurRoom setScript: egoOutOfBedAndDressed)
		)
	)

	(method (newRoom newRoomNumber)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (gEgo onControl: 1) $4000)
				(HandsOff)
				(gCurRoom setScript: changeRoom)
			)
		)
		(super doit:)
	)
)

(instance egoPhoneInBed of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= global105 12)
				(= global106 0)
				(= seconds 3)
				(ShowClock 1)
			)
			(2
				(phoneRing init: play:)
				(= seconds 8)
			)
			(3
				(ShowClock 0)
				(talkInset init:)
				(egoMouth init:)
				(= cycles 1)
				(phoneRing dispose:)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 40 0) ; "Even half-asleep, you recognize Captain Tate's stern voice..."
				(Print 40 1) ; "BONDS!... Rise and shine, pal! I need you back in Homicide today. We've got work to do. Report in plain clothes."
				(= cycles 1)
			)
			(5
				(= save1 1)
				(Print 40 2) ; "Sleepily, you reply..."
				(Say talkInset 40 3) ; "I'll be there before 1400 hours, Captain."
				(egoMouth setCycle: RandCycle 15 self)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(talkInset dispose:)
				(egoMouth dispose:)
				(= cycles 2)
			)
			(7
				(gEgo show:)
				(musicBox show:)
				(carFront dispose:)
				(carBack dispose:)
				(carMid dispose:)
				(carDoor dispose:)
				(gCurRoom drawPic: 40)
				(= cycles 2)
			)
			(8
				(if (== gDay 2)
					(Print 40 4 #at 50 20) ; "You hate waking up without Marie next to you."
				)
				(= cycles 1)
			)
			(9
				(client setScript: egoOutOfBedAndDressed)
			)
		)
	)
)

(instance egoOutOfBedAndDressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gEgo view: 425 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gEgo loop: 1 cel: 0 x: 206 y: 135 setCycle: End self)
			)
			(4
				(gEgo view: 425 setLoop: 2 cel: 5 x: 212 y: 137 normal: 0)
				(= cycles 2)
			)
			(5
				(gEgo setCycle: Walk setMotion: MoveTo 273 159 self)
			)
			(6
				(soundFX number: 160 loop: -1 play:)
				(= seconds 10)
			)
			(7
				(Print 40 5) ; "You go through the motions of getting ready for work."
				(= seconds 2)
			)
			(8
				(soundFX stop:)
				(gEgo view: 4 setLoop: -1 setMotion: MoveTo 235 159 self)
			)
			(9
				(NormalEgo)
				(HandsOn)
				(cond
					((and (not (gEgo has: 5)) (== gDay 2)) ; musicBox
						(musicBox setScript: musicTimer)
					)
					((== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
						(musicBox setScript: musicTimer2)
					)
					(else
						(HandsOff)
						(gCurRoom setScript: leaveForWork)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance musicTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 90)
			)
			(1
				(HandsOff)
				(phoneRing init: play:)
				(gEgo setCycle: Walk setMotion: PolyPath 181 102 self)
			)
			(2
				(gEgo
					view: 427
					loop: 0
					cel: 0
					normal: 0
					setCycle: CT 8 1 self
				)
			)
			(3
				(phoneRing dispose:)
				(Print 40 6) ; "A slightly irritated Captain Tate says... "Come on, Bonds. Time to roll out! Gotta go catch the badguys, remember? Get it in gear!""
				(Say gEgo 40 7) ; "I...uh...I'm leaving now."
				(= seconds 5)
			)
			(4
				(gEgo cel: 8 setCycle: CT 0 1 self)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
			)
			(5
				(gCurRoom setScript: leaveForWork)
			)
		)
	)
)

(instance musicTimer2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 90)
			)
			(1
				(HandsOff)
				(Print 40 8) ; "Looking at the clock, you realize that you're late for work. You must have been day dreaming about Marie."
				(= cycles 1)
			)
			(2
				(gCurRoom setScript: leaveForWork)
			)
		)
	)
)

(instance leaveForWork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 4)
				(gEgo setMotion: PolyPath 155 183 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance goToDresser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 88 107 self)
			)
			(1
				(Print 40 9) ; "Marie's hospital gown is all she needs right now."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getMusicBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 88 107 self)
			)
			(1
				(soundMB init: play:)
				(gEgo
					view: 426
					loop: 0
					cel: 0
					normal: 0
					setCycle: CT 3 1 self
				)
				(gEgo get: 5) ; musicBox
				(proc0_17 20)
			)
			(2
				(musicBox hide:)
				(gEgo cel: 3 setCycle: CT 9 1 self)
			)
			(3
				(= seconds 3)
			)
			(4
				(soundMB dispose:)
				(SetScore 129 5)
				(gEgo y: (- (gEgo y:) 1))
				(NormalEgo 4 1)
				(= cycles 4)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance changeRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom newRoom: 38)
			)
		)
	)
)

(instance dresser of Feature
	(properties
		description {the dressed}
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: goToDresser)
			)
			(2 ; Look
				(Print 40 10) ; "The closet contains Marie's clothes and other personal items."
				(if (not (gEgo has: 5)) ; musicBox
					(Print 40 11) ; "On the shelf there are several of her favorite mementos including a music box."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bed of Feature
	(properties
		description {the bed}
		onMeCheck 512
		lookStr {It's your bed. It looks empty without Marie.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 40 12) ; "Anything you could 'do' with the bed wouldn't be any fun without Marie."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance phone of Feature
	(properties
		description {the phone}
		onMeCheck 32
		lookStr {You glance at the phone and hope that nobody bothers you at home for once.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 40 13) ; "There's no one you need to call."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nightStand of Feature
	(properties
		description {the night stand}
		onMeCheck 256
		lookStr {It's a night stand.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 40 14) ; "The night stand doesn't interest you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rm40window of Feature
	(properties
		description {the window}
		onMeCheck 64
		lookStr {Outside the Lytton suburbs look peaceful.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 40 15) ; "The temperature in the room is fine. You decide not to open the window."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance readingArea of Feature
	(properties
		description {the furniture}
		onMeCheck 4096
		lookStr {Marie curls up in that chair for hours. This is her favorite little reading area.}
	)
)

(instance furnishings of Feature
	(properties
		description {the room}
		onMeCheck 2048
		lookStr {Marie was so excited about buying this house. She loved decorating this room and hand-picking each accessory.}
	)
)

(instance chair of Feature
	(properties
		description {the chair}
		onMeCheck 8192
		lookStr {Marie curls up in that chair for hours. This is her favorite little reading area.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 40 16) ; "You don't have time to sit down and read. You're late for work."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance musicBox of Prop
	(properties
		x 75
		y 63
		description {the music box}
		lookStr {The music box plays Marie's favorite song. She liked to listen to it while you were on duty because it reminded her of you.}
		view 429
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: getMusicBox)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance carFront of View
	(properties
		x 205
		y 150
		view 209
		loop 2
		signal 1
	)
)

(instance carMid of View
	(properties
		x 238
		y 170
		view 209
		loop 2
		cel 1
		signal 1
	)
)

(instance carBack of View
	(properties
		x 285
		y 170
		view 209
		loop 2
		cel 2
		signal 1
	)
)

(instance carDoor of Prop
	(properties
		x 219
		y 143
		view 209
		loop 3
	)
)

(instance talkInset of View
	(properties
		x 66
		y 93
		view 428
		priority 15
		signal 17
	)
)

(instance egoMouth of Prop
	(properties
		x 97
		y 93
		z 23
		view 428
		loop 1
		priority 15
		signal 16
	)
)

(instance phoneRing of Sound
	(properties
		number 935
		priority 15
		loop -1
	)
)

(instance soundMB of Sound
	(properties
		number 351
		loop -1
	)
)

(instance soundFX of Sound
	(properties)
)

