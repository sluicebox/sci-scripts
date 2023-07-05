;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 556)
(include sci.sh)
(use Main)
(use rmnScript)
(use eRS)
(use Motion)
(use Actor)

(public
	rm556 0
)

(local
	local0
)

(procedure (localproc_0)
	(Display 556 0 dsRESTOREPIXELS local0)
)

(instance rm556 of SQRoom
	(properties
		picture 556
	)

	(method (init)
		(super init:)
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
				(rogerJrArm init: setCel: 4)
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

(instance holoScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rogerHead setCycle: Fwd)
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"You mus..."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= local0
					(proc0_12
						{"Is it tr..."}
						67
						2
						12
						28
						global140
						29
						global129
						30
						1
						70
						315
					)
				)
				(= seconds 5)
			)
			(2
				(rogerHead setCycle: Fwd)
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"You go fir..."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= local0
					(proc0_12
						{"I'm so..."}
						67
						2
						12
						28
						global140
						29
						global129
						30
						1
						70
						315
					)
				)
				(= seconds 5)
			)
			(4
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"You must be very confused."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 7)
			)
			(6
				(rogerHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"Were Vohaul's words true? Are you really my son? You do look a little like me, though not as good-looking."}
							67
							2
							12
							28
							global140
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 12)
			)
			(8
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"What do you mean 'not as good-looking'? I'm ten time... wait. What am I saying? This is no way to start. Yes, what Vohaul said is true. I have many things to tell you, dad. I should start at the beginning."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 15)
			)
			(10
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"I was born nineteen years ago on Xenon. It has always been my home. The Xenon of today, at least up until recently, had made great strides in managing our planet's resources."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(12
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"That included water, minerals, even the talent of our population. We enjoyed peace for so many years that we took it for granted."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(14
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"The creation of the first Super BioMech Computer was the biggest success story in our history."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(16
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"It was able to store, organize, and analyze all the knowledge Xenon's intellectual, scientific, and artistic communities had to offer. As a result great technological strides were made."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(18
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"When the Vohaul virus was introduced and began to control the computer, a state of total chaos was created. We were unprepared for what followed as Vohaul turned our technology against us."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(20
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"The population was quickly decimated. Some of us stayed and tried to fight, some were captured, and some fled the planet."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(22
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"When it seemed there was no hope, we thought of one last longshot effort. That was to find the only person in history ever to defeat Vohaul."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(24
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"We had to go back in time to find that person - you. We got there just in time."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(26
				(rogerHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"You had to go back in time to get me? Why wasn't I available in this time? What happened to me? I don't understand."}
							67
							2
							12
							28
							global140
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 14)
			)
			(28
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"I'm sorry. There are some things I wish I could tell you but can't. I know that's not what you want to hear. Believe me, I just can't."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 14)
			)
			(30
				(rogerHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"Hey, if you're my son... who's your mother? My wife? Where is she? Who is she?"}
							67
							2
							12
							28
							global140
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 14)
			)
			(32
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"You sure ask a lot of questions for a janitor."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(34
				(rogerJrArm setCycle: End self)
			)
			(35
				(gCurRoom newRoom: 555)
			)
			(else
				(self restore:)
				(localproc_0 local0)
				(rogerHead setCycle: 0)
				(rogerJrHead setCycle: 0)
				(= cycles 1)
			)
		)
	)
)

(instance finaleScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rogerJrArm setLoop: 5 setCel: 0 setCycle: End self)
			)
			(1
				(rogerHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"I don't believe all this. I'm so confused."}
							67
							2
							12
							28
							global140
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 9)
			)
			(3
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"It doesn't matter now. I have to send you back where I found you so that history will properly reflect the events which brought us to this place in time. You won't remember much. This will seem like it was a weird, fuzzy dream."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 14)
			)
			(5
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"I must get to the task of contacting all the surviving citizens of our planet. We have a huge task ahead of us. Rebuilding our city and our lives will not be easy, but we will do it."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 12)
			)
			(7
				(rogerJrHead setCycle: Fwd)
				(self
					save1:
						(proc0_12
							{"Once more I have to ask you to enter the time rip. It will return you to Magmetheus in the Space Quest IV era. Please go now. It's time."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 12)
			)
			(10
				(rogerJrArm setLoop: 6 setCel: 0 setCycle: End)
				(rogerArm init: setCycle: End)
				(= cycles 2)
			)
			(11
				(rogerJrArm dispose:)
				(= cycles 5)
			)
			(12
				(gLongSong fade:)
				(gCurRoom newRoom: 540)
			)
			(else
				(self restore:)
				(rogerHead setCel: 0 setCycle: 0)
				(rogerJrHead setCel: 0 setCycle: 0)
				(= cycles 1)
			)
		)
	)
)

(instance rogerHead of Prop
	(properties
		x 198
		y 67
		view 555
	)
)

(instance rogerJrHead of Prop
	(properties
		x 113
		y 66
		view 555
		loop 1
	)
)

(instance rogerJrArm of Prop
	(properties
		x 114
		y 73
		view 555
		loop 4
		priority 5
		signal 16400
	)
)

(instance rogerArm of Prop
	(properties
		x 189
		y 85
		view 555
		loop 7
		priority 4
		signal 16400
	)
)

