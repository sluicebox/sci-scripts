;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 555)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use System)

(public
	rm555 0
)

(instance rm555 of SQRoom
	(properties
		picture 555
	)

	(method (init)
		(super init:)
		(Load rsVIEW 557)
		(Load rsSOUND 813)
		(holo init: hide:)
		(self setScript: realyStupidScript)
	)
)

(instance realyStupidScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(UnLoad 129 556)
				(= cycles 3)
			)
			(2
				(aSound number: 813 loop: 1 init: play:)
				(holo show: cycleSpeed: 4 setCycle: CT 1 1 self)
			)
			(3
				(holo hide:)
				(hair init: setCycle: ForwardCounter 40)
				(= seconds 2)
			)
			(4
				(aSound stop:)
				(= seconds 1)
			)
			(5
				(tROGJR ; "This is my mother and your wife. Her name was Beatrice, Beatrice Wankmeister. She was quite beautiful, wasn't she."
					say: 13 self 2 64 5 20 25 global150 26 global129 27 1 67 125
				)
			)
			(6
				(tROGER ; "What do you mean, WAS quite beautiful'? What are you saying."
					say: 5 self 2 64 5 20 25 global140 26 global129 27 1 67 125
				)
			)
			(7
				(tROGJR ; "I'm so sorry! I shouldn't have said that! Please, I can't tell you any more."
					say: 14 self 2 64 5 20 25 global150 26 global129 27 1 67 125
				)
			)
			(8
				(aSound number: 813 loop: 1 init: play:)
				(hair hide:)
				(holo show:)
				(= cycles 4)
			)
			(9
				(holo setCycle: CT 0 -1 self)
			)
			(10
				(holo dispose:)
				(UnLoad 128 557)
				(= seconds 2)
			)
			(11
				(aSound stop:)
				(gCurRoom newRoom: 556)
			)
		)
	)
)

(instance hair of Sq4Prop
	(properties
		x 176
		y 32
		sightAngle 180
		view 557
		loop 1
		priority 7
		signal 16400
		lookStr 2 ; "Her golden hair blows in the breeze, and you wonder how you could get so lucky."
	)
)

(instance holo of Sq4Prop
	(properties
		x 167
		y 120
		sightAngle 180
		view 557
		priority 6
		signal 16400
		lookStr 4 ; "You gaze at the image of the beautiful woman and look forward to the day that you finally meet her."
	)
)

(instance aSound of Sound
	(properties
		number 813
	)
)

(instance tROGER of Sq4Narrator
	(properties
		noun 7
		modNum 557
		modeless 1
		talkerNum 7
	)
)

(instance tROGJR of Sq4Narrator
	(properties
		noun 31
		modNum 557
		disposeWhenDone 0
		modeless 1
		talkerNum 31
	)
)

