;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm090 0
)

(instance rm090 of Rm
	(properties
		picture 99
	)

	(method (init)
		(Load rsVIEW 90)
		(Load rsSOUND 93)
		(super init:)
		(aFace init:)
		(aGeneral init:)
		(self setScript: RoomScript)
		(HandsOff)
	)
)

(instance RoomScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(proc0_3)
		(gIceKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evKEYBOARD) (event claimed:))
			(return)
		)
		(if gModelessDialog
			(proc0_3)
			(self cue:)
		)
		(event claimed: 1)
	)

	(method (cue)
		(= cycles (= seconds 0))
		(super cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theSong number: (proc0_5 93) loop: -1 play:)
				(Print 90 0 #at -1 140 #dispose) ; "After landing aboard the aircraft carrier USS Saratoga, you attend a mandantory debriefing with the Captain and his staff where you learn the following:"
				(= seconds 9)
			)
			(1
				(aFace setCycle: Fwd)
				(Print 90 1 #title {Captain} #at 5 10 #width 305 #font 3 #dispose) ; "Commander Westland," says the Captain, "United States Intelligence confirmed that the terrorist group guilty of the abduction of Ambassador Loyd was, in fact, infiltrated by the Russian KGB."
				(= seconds 9)
			)
			(2
				(aFace setCel: 0)
				(= cycles 3)
			)
			(3
				(aFace setCycle: Fwd)
				(Print 90 2 #title {Captain} #at 5 10 #width 305 #font 3 #dispose) ; "Further," he continues, "the KGB instigated the abduction knowing the incident would strain relations between the United States and Tunisia."
				(= seconds 9)
			)
			(4
				(aFace setCel: 0)
				(= cycles 3)
			)
			(5
				(aFace setCycle: Fwd)
				(Print 90 3 #title {Captain} #at 5 10 #width 305 #font 3 #dispose) ; "The underlying motive being," he emphasizes, "that Tunisia would finally sever relations with the United States and halt the oil trade."
				(= seconds 9)
			)
			(6
				(aFace setCel: 0)
				(= cycles 3)
			)
			(7
				(aFace setCycle: Fwd)
				(Print 90 4 #title {Captain} #at 5 10 #width 305 #font 3 #dispose) ; "The Captain continues, "Had the incident been successful, the effect would have left the USSR manipulating the bulk of the world's highest-grade crude oil.""
				(= seconds 9)
			)
			(8
				(aFace setCel: 0)
				(= cycles 3)
			)
			(9
				(aFace setCycle: Fwd)
				(Print 90 5 #title {Captain} #at 5 10 #width 305 #font 3 #dispose) ; "This is my friend, would have had definite negative impact on the economy of the United States."
				(= seconds 9)
			)
			(10
				(aFace setCel: 0)
				(= cycles 3)
			)
			(11
				(aFace setCycle: Fwd)
				(Print 90 6 #title {Captain} #at 5 10 #width 305 #font 3 #dispose) ; "In a voice of praise he says, "The success of your mission Commander Westland, has turned the the tables on the KGB effort and, more important, will expose to the world their devious methods of operation.""
				(= seconds 9)
			)
			(12
				(aFace setCel: 0)
				(= cycles 3)
			)
			(13
				(aFace setCycle: Fwd)
				(Print 90 7 #title {Captain} #at 5 10 #width 305 #font 3 #dispose) ; "In closing, the Captain says to you, "Commander, words cannot express the appreciation we feel for the success of your mission. The United States Navy is very proud of you!""
				(= seconds 9)
			)
			(14
				(aFace setCel: 0)
				(= cycles 3)
			)
			(15
				(aFace setCycle: Fwd)
				(Print 90 8 #title {Captain} #at 5 10 #width 305 #font 3 #dispose) ; "And now, Commander Westland, above us on the flight deck of the Saratoga, a special award ceremony awaits you!"
				(= seconds 9)
			)
			(16
				(aFace setCel: 0)
				(theSong fade:)
				(= seconds 3)
			)
			(17
				(proc0_3)
				(gCurRoom newRoom: 89)
			)
		)
	)
)

(instance aGeneral of View
	(properties
		y 144
		x 158
		view 90
	)

	(method (init)
		(super init:)
		(self ignoreActors:)
	)
)

(instance aFace of Prop
	(properties
		y 79
		x 157
		view 90
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 15)
	)
)

(instance theSong of Sound
	(properties
		priority 15
	)
)

