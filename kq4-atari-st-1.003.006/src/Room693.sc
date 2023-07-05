;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 693)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room693 0
)

(local
	local0
	local1
)

(instance Room693 of Rm
	(properties
		picture 201
		style 8
	)

	(method (init)
		(super init:)
		(self setRegions: 521) ; RgEnd
		(= local1 (View new:))
		(local1 view: 767 loop: 0 cel: 3 posn: 270 137 setPri: 15 init:)
		((View new:) view: 768 loop: 0 cel: 0 posn: 157 65 init: addToPic:)
		((View new:) view: 769 loop: 3 cel: 0 posn: 48 139 init: addToPic:)
		(gEgo setScript: egoActions)
	)
)

(instance egoActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Timer setReal: self 2)
				(User canControl: 0 canInput: 0)
			)
			(1
				(= local0 (Prop new:))
				(local0
					view: 687
					loop: 0
					cel: 0
					posn: 225 149
					setPri: 15
					ignoreActors:
					setCycle: CT 3 1 self
					init:
				)
			)
			(2
				(gEgo
					view: 759
					setLoop: -1
					loop: 1
					cel: 2
					posn: 225 149
					init:
				)
				(local0 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(if (gEgo has: 25) ; Magic_Fruit
					(self changeState: 10)
				else
					(self changeState: 5)
				)
			)
			(5
				(gEgo setMotion: MoveTo 245 220 self)
			)
			(6
				(gCurRoom newRoom: 694)
			)
			(10
				(gEgo setCycle: Walk setMotion: MoveTo 253 135 self)
			)
			(11
				(gEgo loop: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(12
				(local1 dispose:)
				(gEgo setCycle: End self)
			)
			(13
				(gEgo
					view: 759
					loop: 1
					setCycle: Walk
					setMotion: MoveTo 245 220 self
				)
			)
			(14
				(gCurRoom newRoom: 694)
			)
		)
	)
)

