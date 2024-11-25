;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use Sound)
(use Motion)
(use System)

(public
	rm620 0
)

(local
	local0
	[local1 45] = [0 0 0 0 100 55 0 119 40 5 87 16 0 43 45 5 21 7 0 98 45 1 154 67 2 212 7 3 170 10 4 145 11 5 105 5 0 98 28 5 113 12 -1 142 13]
)

(instance rm620 of SQRoom
	(properties
		picture 620
	)

	(method (init)
		(SetFlag 15)
		(gEgo
			init:
			view: 625
			setLoop: 3
			normal: 0
			posn: 100 55
			setScript: flyScript
			setPri: 5
			illegalBits: $8000
			ignoreActors: 1
			setStep: 6 6
		)
		(mono1 init: setCel: 1 setPri: 4)
		(mono2 init: setPri: 4)
		(mono3 init: setPri: 14)
		(monoTalker init: 0 0 mono3)
		(super init:)
		(self setRegions: 706) ; ulence
		(if (!= gPrevRoomNum 615)
			(gLongSong2 vol: 85 number: 804 loop: -1 playBed:)
		)
		(Load rsSOUND 881)
		(Load rsSOUND 882)
		(gLongSong flags: 1)
		(gLongSong2 flags: 1)
		(self setScript: mono3Script)
	)
)

(instance mono3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mono1 setCel: 0)
				(= cycles 2)
			)
			(1
				(monoTalker ; "Well, lookee here! If it ain't Mister Look-at-me-I'm-in-VGA."
					say: 1 self 2 64 177 5 25 global130 26 global129 67 150
				)
			)
			(2
				(monoTalker ; "Whatsamatter, monochrome not good enough for you?"
					say: 3 self 2 64 177 5 25 global130 26 global129 67 140
				)
			)
			(3
				(monoTalker ; "What's dis? 256 colors all for one little bitmapped WIMP?! Whatta waste of VGA. Har, har!"
					say: 4 self 2 64 177 5 25 global130 26 global129 67 140
				)
			)
			(4
				(monoTalker ; "Hey, fellas! I bet I can toss him all the way out from the bottom of the stairs. Bet ya an ale."
					say: 6 self 2 64 177 5 25 global130 26 global129 67 150
				)
			)
			(5
				(mono3 setCycle: 0)
				(gEgo setScript: 0 setMotion: 0)
				(gLongSong2 fade: 70 10 10 0)
				(gCurRoom newRoom: 610)
			)
			(6
				(mono3 setCel: 0)
				(if (not local0)
					(= local0 1)
				else
					(mono1 setCycle: Fwd)
					(= local0 0)
				)
			)
		)
	)
)

(instance mono1 of Sq4Prop
	(properties
		x 77
		y 53
		view 625
		loop 4
	)
)

(instance mono2 of Sq4Prop
	(properties
		x 143
		y 27
		view 625
		loop 1
	)
)

(instance mono3 of Sq4Prop
	(properties
		x 229
		y 50
		view 625
	)
)

(instance flyScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(mono2 setCel: 1)
				(gEgo setCycle: End self)
			)
			(2
				(= cycles (Random 10 15))
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(= cycles (Random 5 10))
			)
			(5
				(mono2 setCel: 0)
				(gEgo setCycle: End self)
			)
			(6
				(= cycles (Random 5 10))
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(buzzSound play:)
				(gEgo setMotion: MoveTo 119 40 self)
			)
			(9
				(gEgo setMotion: MoveTo 87 16 self setPri: 3)
			)
			(10
				(gEgo setMotion: MoveTo 43 45 self)
			)
			(11
				(mono2 setCel: 5)
				(gEgo setMotion: MoveTo 21 7 self)
			)
			(12
				(gEgo setMotion: MoveTo 98 45 self setPri: 5)
			)
			(13
				(mono2 setCel: 1)
				(gEgo setMotion: MoveTo 154 67 self)
			)
			(14
				(gEgo setMotion: MoveTo 212 7 self)
			)
			(15
				(gEgo setMotion: MoveTo 170 10 self)
			)
			(16
				(mono2 setCycle: CT 3 1)
				(gEgo setMotion: MoveTo 145 11 self)
			)
			(17
				(gEgo setMotion: MoveTo 105 5 self)
			)
			(18
				(mono2 setCel: 0)
				(gEgo setMotion: MoveTo 98 28 self)
			)
			(19
				(mono2 setCel: 5)
				(gEgo setMotion: MoveTo 113 12 self)
			)
			(20
				(gEgo setMotion: MoveTo 142 13 self)
			)
			(21
				(buzzSound number: 882 play:)
				(mono2 setLoop: 2 setCycle: End self)
			)
			(22
				(= cycles (Random 5 10))
			)
			(23
				(gEgo hide:)
				(mono2 setCycle: Beg self)
			)
			(24
				(mono2 setLoop: 1 setCycle: CT 1 1)
				(= seconds 5)
			)
			(25
				(self dispose:)
			)
		)
	)
)

(instance buzzSound of Sound
	(properties
		flags 1
		number 881
	)
)

(instance monoTalker of FaceTalker
	(properties
		noun 10
		modNum 620
		talkerNum 10
	)
)

