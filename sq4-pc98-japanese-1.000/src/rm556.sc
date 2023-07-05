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
	(Display 556 1 dsRESTOREPIXELS local0)
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
							{"You mus..."#j\a2\97\f0\ea\a5\a5\a5\a5\a3}
							67
							2
							0
							28
							global137
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
						{"Is it tr..."#j\a2\ee\fd\e4\a5\a5\a5\a5\a3}
						67
						2
						10
						28
						global189
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
							{"You go fir..."#j\a2\ee\de\98\e9\a5\a5\a5\a5\a3}
							67
							2
							0
							28
							global137
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
						{"I'm so..."#j\a2\9f\fd\e5\a5\a5\a5\a5\a3}
						67
						2
						10
						28
						global189
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
							{"You must be very confused."#j\a2\e4\e3\f3\a4\a0 \9a\fd\f7\fd\9c\e3\92\f9\f6\93\e3\de\9d\e8\a1\a3}
							67
							2
							0
							28
							global137
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
							{"Were Vohaul's words true? Are you really my son? You do look a little like me, though not as good-looking."#j\a2\b3\de\ab\ce\b0\d9\e9\a0\9a\e4\ea\de\ea\a0\ee\fd\e4\93\96\fe\n\97\f0\ea\a4\a0 \ee\fd\e4\93\e6\a0\ee\de\98\e9\a0 \f1\9d\9a\e5\e9\96\fe\n\9f\93\92\94\ea\de\a4\a0 \e4\de\9a\e4\e5\98\a0 \ee\de\98\e6\a0 \e6\e3\92\f9\f6\93\e0\de\96\de\a5\a5\a5\a5\a1\n\e3\de\f3\a4\a0 \ee\de\98\e9\ee\93\96\de\a0 \ca\dd\bb\d1\e0\de\e5\a1\a3}
							67
							2
							10
							28
							global189
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
							{"What do you mean 'not as good-looking'? I'm ten time... wait. What am I saying? This is no way to start. Yes, what Vohaul said is true. I have many things to tell you, dad. I should start at the beginning."#j\a2\ee\de\98\e9\ee\93\96\de\a4\a0 \ca\dd\bb\d1\a0 \e4\ea\a4\a0 \e4\de\93\92\93\92\f0\e0\de\fe\n\ee\de\98\e9\ee\93\96\de\a5\a5\a5\a5\a1\a0 \ef\e3\f6\ff\a0 \9a\fd\e5\9a\e4\86\92\8f\e3\e3\f3\9c\96\e0\96\de\e5\92\a1\n\93\fd\a4\9f\93\e0\de\f6\a1\a0 \b3\de\ab\ce\b0\d9\96\de\92\8f\e0\9a\e4\ea\a4\a0 \ee\fd\e4\93\e0\de\f6\a1\n\95\e4\93\9b\fd\e6\a4\a0 \92\fb\92\fb\ea\e5\9c\e0\92\9a\e4\96\de\91\f9\fd\e0\de\a1\n\ef\9d\de\a4\a0 \9b\92\9c\8e\96\f7\ea\e5\9d\e8\a1\a3}
							67
							2
							0
							28
							global137
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
							{"I was born nineteen years ago on Xenon. It has always been my home. The Xenon of today, at least up until recently, had made great strides in managing our planet's resources."#j\a2\ee\de\98\ea\a4\a0 19\e8\fd\ef\94\e6\a0\be\de\c9\dd\e3\de\93\ef\fa\e0\fd\e0\de\a1 \n\be\de\c9\dd\ea\a4\a0 \ee\de\98\e9\ec\f9\9b\e4\a1\a0 \ee\9c\e9\9c\99\de\fd\86\a0\93\ef\98\f4\f8\98\f8\9c\e3\92\98\9a\e4\e3\de\a0 \n\9d\ea\de\f7\9c\92\a0\eb\f4\98\86\a0 \e4\99\de\e3\97\e0\fd\e0\de\a1\a3}
							67
							2
							0
							28
							global137
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
							{"That included water, minerals, even the talent of our population. We enjoyed peace for so many years that we took it for granted."#j\a2\9c\99\de\fd\e4\92\93\e9\ea\a4\a0 \f0\9d\de\f4\a0\d0\c8\d7\d9\a4\a0 \e6\fd\99\de\fd\e9\c0\da\dd\c4\96\de\a0 \ec\98\ef\fa\e3\f9\fd\e0\de\a1\n\9c\96\9c\a4\a0 \eb\e4\eb\de\e4\e9\a0 \9a\9a\fb\ea\a0 \9a\9a\9c\ea\de\f7\98\a0 \9d\de\8f\e4\ed\92\fc\a0\e0\de\8f\e0\e9\e3\de\a4\a0 \9f\fa\86\a0\91\f8\96\de\e0\92\fd\e5\fd\e3\a0\95\f3\8f\e3\e5\96\8f\e0\e9\9b\a1\a3}
							67
							2
							0
							28
							global137
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
							{"The creation of the first Super BioMech Computer was the biggest success story in our history."#j\a2\9f\e9\9a\de\e9\a0\bd\b0\ca\df\b0\a5\ca\de\b2\b5\d2\af\b8\a5\ba\dd\cb\df\ad\b0\c0\b0\99\92\96\98\e9\a0\n\9e\92\9a\93\ea\a0\be\de\c9\dd\9e\92\e9\fa\97\9c\9c\de\8e\93\a0 \9b\92\e0\de\92\e9\a0 \9e\92\9a\93\e0\de\8f\e0\fd\e0\de\a1\a3}
							67
							2
							0
							28
							global137
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
							{"It was able to store, organize, and analyze all the knowledge Xenon's intellectual, scientific, and artistic communities had to offer. As a result great technological strides were made."#j\a2\9f\e9\ba\dd\cb\df\ad\b0\c0\b0\ea\a4\a0 \be\de\c9\dd\e9\9d\ed\de\e3\e9\a0 \96\de\98\9c\8c\e0\e1\e9\a0 \e1\9c\97\86\e0\98\fc\94\a4\a0 \ec\de\fd\9e\97\a0 \9d\f9\9a\e4\96\de\e3\de\97\e0\fd\e0\de\a1\a0 \n\9f\e9\99\8f\96\a4\a0 \97\de\9c\de\8d\e2\f8\8e\98\96\de\a0 \eb\f4\98\e3\97\e6\a0 \9a\93\9c\de\8e\93\9c\e0\e9\9b\a1\a3}
							67
							2
							0
							28
							global137
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
							{"When the Vohaul virus was introduced and began to control the computer, a state of total chaos was created. We were unprepared for what followed as Vohaul turned our technology against us."#j\a2\e4\9a\fb\96\de\a4\a0 \b3\de\ab\ce\b0\d9\96\de\a0 \b3\a8\d9\bd\86\e2\96\8f\e3\a4\a0 \bd\b0\ca\df\b0\a5\ba\dd\cb\df\ad\b0\c0\b0\86\a0\ba\dd\c4\db\b0\d9\9c\ea\9c\de\f2\e0\e9\9b\a1\a0 \n\be\de\c9\dd\ea\a0\e0\de\92\9a\fd\f7\fd\e6\a0\95\e1\92\8f\e3\9c\ef\8f\e0\a1\a0 \n\b3\de\ab\ce\b0\d9\96\de\a4\a0 \ee\de\98\e0\e1\e9\c3\b8\c9\db\bc\de\b0\86\e2\96\92\a4\a0 \be\de\c9\dd\e9\e4\9c\86\a0 \9a\93\99\de\97\9c\e3\97\e0\fd\e0\de\a1\a3}
							67
							2
							0
							28
							global137
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
							{"The population was quickly decimated. Some of us stayed and tried to fight, some were captured, and some fled the planet."#j\a2\9c\de\fd\9a\93\ea\a0\91\8f\e4\92\93\ef\e6\a0\ed\8f\e3\9c\ef\8f\e0\a1\a0 \ee\de\98\e0\e1\ea\a0 \e9\9a\8f\e3\a0 \e0\e0\96\95\93\e4\9c\e0\fd\e0\de\99\e4\de\a4\a0 \ee\e4\fd\e4\de\ea\a0\e2\96\ef\8f\e3\9c\ef\92\a4\a0 \e9\9a\8f\e0\a0 \e5\fd\e6\fd\96\ea\a0 \ee\9c\86\a0\e0\de\8f\9c\8d\e2\9c\e0\fd\e0\de\a1\a3}
							67
							2
							0
							28
							global137
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
							{"When it seemed there was no hope, we thought of one last longshot effort. That was to find the only person in history ever to defeat Vohaul."#j\a2\f3\93\a4\a0 \91\97\f7\f2\96\99\e0\e4\97\a0\ee\de\98\e0\e1\ea\a0 \91\f9\9a\e4\86\a0\96\fd\96\de\94\e0\fd\e0\de\a1\a0 \9f\fa\ea\a0\e2\ef\f8\a4\a0 \fa\97\9c\9c\de\8e\93\a0 \b3\de\ab\ce\b0\d9\86\a0\f4\8f\e2\99\e0\a0\e0\e0\de\eb\e4\f8\e9\a0 \9c\de\fd\ec\de\e2\86\f0\e2\99\f9\9a\e4\a1\a0 \n\9f\e9\eb\e4\86\a0\9b\96\de\9d\e0\f2\e6\a0 \ee\de\98\e0\e1\ea\a0 \9c\de\96\fd\86\a0\9b\96\e9\ee\de\f7\e5\99\fa\ea\de\a0 \e5\f7\e5\96\8f\e0\fd\e0\de\a1\a3}
							67
							2
							0
							28
							global137
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
							{"We had to go back in time to find that person - you. We got there just in time."#j\a2\e2\ef\f8\a4\a0 \9f\e9\eb\e4\96\de\a0 \91\e5\e0\e5\fd\e0\de\a1 \n\97\de\f8\97\de\f8\e3\de\a0 \ef\e6\91\8f\e0\f6\93\e0\de\a1\a3}
							67
							2
							0
							28
							global137
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
							{"You had to go back in time to get me? Why wasn't I available in this time? What happened to me? I don't understand."#j\a2\ee\de\98\86\a0 \9b\96\de\9d\e0\f2\e6\a0 \9c\de\96\fd\86\a0\9b\96\e9\ee\de\8f\e0\fe\a0 \n\9f\e9\e4\97\a0 \ee\de\98\ea\a0 \e4\de\9a\e6\92\e0\fd\e0\de\fe\a0 \e4\de\93\9c\e3\a0\9f\9a\e6\92\e5\96\8f\e0\fd\e0\de\fe\a3}
							67
							2
							10
							28
							global189
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
							{"I'm sorry. There are some things I wish I could tell you but can't. I know that's not what you want to hear. Believe me, I just can't."#j\a2\f3\93\9c\fc\99\e5\92\a1\a0 \95\9c\94\e3\91\99\de\f7\fa\e5\92\9a\e4\f3\a0\91\f9\fd\e0\de\a1\a0 \n\91\f9\9a\e4\e6\96\fd\9c\e3\ea\a4\a0 \ee\fd\e4\93\e6\a0\e5\e6\f3\92\94\e5\92\fd\e0\de\a1\a3}
							67
							2
							0
							28
							global137
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
							{"Hey, if you're my son... who's your mother? My wife? Where is she? Who is she?"#j\a2\95\92\a4\a0 \97\f0\96\de\a0 \ee\de\98\e9\f1\9d\9a\e5\f7\a4\a0 \92\8f\e0\92\a5\a5\a5\a5\a1\n\e0\de\fa\96\de\a0 \97\f0\e9\a0\95\96\91\9b\fd\e5\fd\e0\de\fe\a0 \ee\de\98\e9\a0 \e2\ef\96\fe\a0 \n\96\e9\9c\de\8e\ea\a0 \e4\de\9a\e6\92\f9\fd\e0\de\fe\a0 \e0\de\fa\e5\fd\e0\de\fe\a3}
							67
							2
							10
							28
							global189
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
							{"You sure ask a lot of questions for a janitor."#j\a2\9f\93\9c\de\f4\e6\a0 \9c\e3\ea\a0\92\8f\ea\df\92\a0\9c\e2\f3\fd\9d\f9\e8\a1\a3}
							67
							2
							0
							28
							global137
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
							{"I don't believe all this. I'm so confused."#j\a2\9c\fd\9c\de\f7\fa\e5\92\a5\a5\a5\a5\a1\a0 \91\e0\ef\96\de\a0 \9a\fd\f7\fd\a0 \9c\e3\97\e0\a1\a3}
							67
							2
							10
							28
							global189
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
							{"It doesn't matter now. I have to send you back where I found you so that history will properly reflect the events which brought us to this place in time. You won't remember much. This will seem like it was a weird, fuzzy dream."#j\a2\9f\fd\e5\9a\e4\ea\a0 \92\ef\ea\a0\f3\fd\e0\de\92\9c\de\8c\e5\92\f6\a1\n\e4\e6\96\98\a0 \9c\de\96\fd\e9\a0\f1\9c\de\8d\fd\96\de\a0 \e3\de\e5\92\93\e1\e6\a0\91\e5\e0\86\a0 \f3\e4\e9\ea\de\9c\8e\e6\a0\96\94\9b\e5\99\fa\ea\de\a0 \e0\92\ed\fd\e0\de\a1\a0 \n\f3\e4\de\8f\e3\f3\a0\ee\de\98\e4\e9\9a\e4\ea\a4\a0 \91\fd\ef\f8\a0 \95\ee\de\94\e3\e5\92\ea\9d\de\e0\de\f6\a1\a0 \n\97\8f\e4\a4\a0 \ed\fd\e5\f5\f2\a0\e0\de\8f\e0\e4\a0\95\f3\93\f6\a1\a3}
							67
							2
							0
							28
							global137
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
							{"I must get to the task of contacting all the surviving citizens of our planet. We have a huge task ahead of us. Rebuilding our city and our lives will not be easy, but we will do it."#j\a2\ee\de\98\ea\a4\a0 \92\97\e9\9a\8f\e3\f9\be\de\c9\dd\9e\92\e9\a0\eb\e4\eb\de\e4\e4\a0 \fa\fd\f7\98\86\a0\e4\f7\e5\97\8c\e5\fd\e5\92\fd\e0\de\a1\a0 \92\8f\9a\98\f3\a0\ea\f4\98\a4\a0 \e4\9c\86\a0\9b\92\99\fd\9c\e3\a0 \eb\e4\eb\de\e4\e9\9e\92\96\e2\86\a0\e0\e3\e5\95\9c\e3\92\96\e5\97\8c\a1\a3}
							67
							2
							0
							28
							global137
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
							556
							0
							67
							2
							0
							28
							global137
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

