;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use SQRoom)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm017 0
)

(instance rm017 of SQRoom
	(properties
		picture 17
	)

	(method (init &tmp [temp0 50])
		(HandsOff)
		(Load rsVIEW 6)
		(Load rsVIEW 12)
		(super init:)
		(Palette palUNSET_FLAG 1 64 1)
		(egoHead init:)
		(spArm init:)
		(self setScript: rmScript setRegions: 707) ; intro
	)
)

(instance rmScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (gLongSong prevSignal:) 10) (== state 1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 22 loop: 1 vol: 127 play:)
				(= seconds 3)
			)
			(1
				(spArm setCel: 1)
			)
			(2
				(static init: play:)
				(vohaulHolo init: setCycle: End self)
			)
			(3
				(egoHead setCel: 1)
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(vohaulHolo setLoop: 2 cel: 0 setCycle: ForwardCounter 3 self)
			)
			(5
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(6
				(vohaulHolo setLoop: 2 cel: 0 setCycle: ForwardCounter 5 self)
			)
			(7
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(8
				(vohaulHolo setLoop: 0 setCel: 16 setCycle: Beg self)
			)
			(9
				(static dispose:)
				(vohaulHolo dispose:)
				(= seconds 2)
			)
			(10
				(egoHead setCel: 0)
				(spArm setCel: 0)
				(= seconds 2)
			)
			(11
				(gCurRoom newRoom: 15)
			)
		)
	)
)

(instance spArm of Prop
	(properties
		x 223
		y 109
		view 12
	)
)

(instance egoHead of Prop
	(properties
		x 61
		y 125
		view 12
		loop 1
	)
)

(instance vohaulHolo of Prop
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

