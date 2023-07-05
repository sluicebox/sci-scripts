;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 556)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use Motion)
(use System)

(public
	rm556 0
)

(local
	local0
)

(instance rm556 of SQRoom
	(properties
		picture 556
		style 10
	)

	(method (init)
		(super init:)
		(Load rsVIEW 1555)
		(switch gPrevRoomNum
			(150
				(rogerHead init:)
				(rogerJrHead init:)
				(rogerJrArm init:)
				(self setScript: holoScript)
			)
			(555
				(rogerHead init:)
				(rogerJrHead init:)
				(rogerJrArm init: show: setCel: 5)
				(self setScript: finaleScript)
			)
			(else
				(rogerHead init:)
				(rogerJrHead init:)
				(rogerJrArm init:)
				(self setScript: holoScript)
			)
		)
	)
)

(instance holoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
			)
			(1
				(tROGER init: 0 0 rogerHead)
				(tROGJR init: 0 0 rogerJrHead)
				(if (& gMessageMode $0001)
					(tROGER ; "Is it tr..."
						say: 7 0 2 64 2 12 25 global140 26 global129 27 1 67 315
					)
					(tROGJR ; "You mus..."
						say:
							20
							self
							2
							64
							2
							2
							25
							global150
							26
							global129
							27
							1
							67
							315
					)
				else
					(rogerHead setCycle: End)
					(rogerJrHead setCycle: End)
					(tROGANDROGJR say: 1 self)
				)
			)
			(2
				(tROGER dispose:)
				(rogerHead setCycle: 0 show:)
				(= cycles 2)
			)
			(3
				(tROGER init: 0 0 rogerHead)
				(if (& gMessageMode $0001)
					(tROGER ; "I'm so..."
						modNum: 557
						say: 8 0 2 64 2 12 25 global140 26 global129 27 1 67 315
					)
					(tROGJR ; "You go fir..."
						say:
							21
							self
							2
							64
							2
							2
							25
							global150
							26
							global129
							27
							1
							67
							315
					)
				else
					(rogerHead setCycle: Beg)
					(rogerJrHead setCycle: Beg)
					(tROGANDROGJR say: 2 self)
				)
			)
			(4
				(tROGER dispose:)
				(rogerHead setCycle: 0 show:)
				(= cycles 2)
			)
			(5
				(tROGER init: 0 0 rogerHead)
				(tROGJR ; "You must be very confused."
					say: 2 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(6
				(tROGER ; "Were Vohaul's words true? Are you really my son? You do look a little like me, though not as good-looking."
					modNum: 557
					say: 2 self 2 64 2 12 25 global140 26 global129 27 1 67 315
				)
			)
			(7
				(tROGJR ; "What do you mean 'not as good-looking'? I'm ten time... wait. What am I saying? This is no way to start. Yes, what Vohaul said is true. I have many things to tell you, dad. I should start at the beginning."
					say: 3 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(8
				(tROGJR ; "I was born nineteen years ago on Xenon. It has always been my home. The Xenon of today, at least up until recently, had made great strides in managing our planet's resources."
					say: 4 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(9
				(tROGJR ; "That included water, minerals, even the talent of our population. We enjoyed peace for so many years that we took it for granted."
					say: 5 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(10
				(tROGJR ; "The creation of the first Super BioMech Computer was the biggest success story in our history."
					say: 6 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(11
				(tROGJR ; "When the Vohaul virus was introduced and began to control the computer, a state of total chaos was created. We were unprepared for what followed as Vohaul turned our technology against us."
					say: 7 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(12
				(tROGJR ; "The population was quickly decimated. Some of us stayed and tried to fight, some were captured, and some fled the planet."
					say: 9 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(13
				(tROGJR ; "When it seemed there was no hope, we thought of one last longshot effort. That was to find the only person in history ever to defeat Vohaul. We had to go back in time to find that person - you. We got there just in time."
					say: 10 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(14
				(tROGER ; "You had to go back in time to get me? Why wasn't I available in this time? What happened to me? I don't understand."
					say: 3 self 2 64 2 12 25 global140 26 global129 27 1 67 315
				)
			)
			(15
				(tROGJR ; "I'm sorry. There are some things I wish I could tell you but can't. I know that's not what you want to hear. Believe me, I just can't."
					say: 11 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(16
				(tROGER ; "Hey, if you're my son... who's your mother? My wife? Where is she? Who is she?"
					say: 4 self 2 64 2 12 25 global140 26 global129 27 1 67 315
				)
			)
			(17
				(tROGJR ; "You sure ask a lot of questions for a janitor."
					say: 12 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(18
				(rogerJrArm setCycle: End self)
			)
			(19
				(gCurRoom newRoom: 555)
			)
		)
	)
)

(instance finaleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
			)
			(1
				(rogerJrArm setLoop: 5 setCel: 0 show: setCycle: End self)
			)
			(2
				(tROGER ; "I don't believe all this. I'm so confused."
					init: 0 0 rogerHead
					say: 6 self 2 64 2 12 25 global140 26 global129 27 1 67 315
				)
			)
			(3
				(tROGJR ; "It doesn't matter now. I have to send you back where I found you so that history will properly reflect the events which brought us to this place in time. You won't remember much. This will seem like it was a weird, fuzzy dream."
					init: 0 0 rogerJrHead
					say: 15 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(4
				(tROGJR ; "I must get to the task of contacting all the surviving citizens of our planet. We have a huge task ahead of us. Rebuilding our city and our lives will not be easy, but we will do it."
					say: 16 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(5
				(tROGJR ; "Once more I have to ask you to enter the time rip. It will return you to Magmetheus in the Space Quest IV era. Please go now. It's time."
					say: 17 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(6
				(rogerJrArm setLoop: 6 setCel: 0 setCycle: End)
				(rogerArm init: setCycle: End)
				(= cycles 1)
			)
			(7
				(if (< (rogerArm cel:) 3)
					(-- state)
				)
				(= cycles 1)
			)
			(8
				(rogerJrArm dispose:)
				(gLongSong fade:)
				(= seconds 3)
			)
			(9
				(gCurRoom newRoom: 540)
			)
		)
	)
)

(instance rogerHead of Sq4Prop
	(properties
		x 198
		y 67
		view 1555
	)
)

(instance rogerJrHead of Sq4Prop
	(properties
		x 113
		y 66
		view 1555
		loop 1
	)
)

(instance rogerJrArm of Sq4Prop
	(properties
		x 114
		y 73
		view 1555
		loop 4
		priority 5
		signal 16400
	)
)

(instance rogerArm of Sq4Prop
	(properties
		x 189
		y 85
		view 1555
		loop 7
		priority 4
		signal 16400
	)
)

(instance tROGER of FaceTalker
	(properties
		noun 7
		modNum 557
		talkerNum 7
	)
)

(instance tROGJR of FaceTalker
	(properties
		noun 31
		modNum 557
		talkerNum 31
	)
)

(instance tROGANDROGJR of Sq4Narrator
	(properties
		noun 7
		modNum 557
		disposeWhenDone 0
		modeless 1
		talkerNum 34
	)
)

