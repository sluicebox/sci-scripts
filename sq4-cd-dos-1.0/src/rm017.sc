;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	rm017 0
)

(local
	local0
)

(instance rm017 of SQRoom
	(properties
		picture 17
	)

	(method (init &tmp [temp0 50])
		(LoadMany rsVIEW 6 12)
		(super init:)
		(rogHead init:)
		(spArm init: stopUpd:)
		(self setScript: rmScript setRegions: 707) ; intro
	)
)

(instance rmScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (>= (gLongSong prevSignal:) 10) (== state 1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 22 loop: -1 vol: 127 play:)
				(= seconds 3)
			)
			(1
				(spArm stopUpd: setCycle: End)
			)
			(2
				(static init: play:)
				(vohaulHolo init: setCycle: End self)
			)
			(3
				(rogHead setCel: 2 stopUpd:)
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(vohaulHolo setLoop: 2 cel: 0)
				(tSLUDGE ; "Hello, Roger Wilco. Surprised to see an old friend? You have no idea how special this moment is for me. This is no chance encounter, I can assure you."
					init: 0 0 vohaulHolo
					say:
						1
						self
						2
						64
						100
						15
						67
						218
						25
						global136
						26
						global129
						27
						1
						30
						68
				)
			)
			(5
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(rogHead setCel: 1 stopUpd:)
				(vohaulHolo setLoop: 2 cel: 0)
				(tSLUDGE ; "I have this one loose end to tie up before I begin my reign as The Supreme Being of All That Exists."
					say:
						2
						self
						2
						64
						100
						15
						67
						218
						25
						global136
						26
						global129
						27
						1
						30
						68
				)
			)
			(7
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(8
				(vohaulHolo setLoop: 2 cel: 0)
				(tSLUDGE ; ""I DO NOT LIKE TO LOSE. You are a blemish on what would otherwise be a perfect record of domination, terror, and invincibility. Besides, I'm still a bit miffed about that asteroid deal in Space Quest II."
					say:
						3
						self
						2
						64
						100
						15
						67
						218
						25
						global136
						26
						global129
						27
						1
						30
						68
				)
			)
			(9
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(10
				(vohaulHolo setLoop: 2 cel: 0)
				(tSLUDGE ; "Anyway, to relieve the pain of my humiliation, and to prevent you from being a pain in my... future, YOU MUST DIE. My charges will take care of the messy details. It's been nice seeing you one last time. Men, do the dirty deed!"
					say:
						4
						self
						2
						64
						100
						15
						67
						218
						25
						global136
						26
						global129
						27
						1
						30
						68
				)
			)
			(11
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(12
				(vohaulHolo setLoop: 0 setCel: 16 setCycle: Beg self)
			)
			(13
				(static dispose:)
				(vohaulHolo dispose:)
				(= seconds 2)
			)
			(14
				(spArm stopUpd: setCycle: Beg self)
			)
			(15
				(Animate (gCast elements:) 0)
				(gCurRoom newRoom: 15)
			)
		)
	)
)

(instance spArm of Sq4Prop
	(properties
		x 223
		y 109
		view 12
	)
)

(instance rogHead of Sq4Prop
	(properties
		x 61
		y 129
		view 12
		loop 1
		priority 14
		signal 17
	)
)

(instance vohaulHolo of Sq4Prop
	(properties
		x 173
		y 91
		view 6
		signal 16384
	)
)

(instance static of Sound
	(properties
		number 111
		loop -1
	)
)

(instance tSLUDGE of FaceTalker
	(properties
		talkerNum 6
	)
)

