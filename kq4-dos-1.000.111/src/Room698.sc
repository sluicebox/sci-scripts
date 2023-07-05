;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 698)
(include sci.sh)
(use Main)
(use Sound)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room698 0
)

(local
	local0
	[local1 84]
)

(instance Room698 of Rm
	(properties
		picture 698
		style 8
	)

	(method (init)
		(Load rsVIEW 699)
		(Load rsVIEW 898)
		(Load rsVIEW 899)
		(super init:)
		(User canControl: 0 canInput: 0)
		(= global205 1)
		(gCurRoom setScript: creditActions)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (or (== (event message:) KEY_x) (== (event message:) KEY_X))
			(gGame restart:)
		else
			(gCurRoom newRoom: 120) ; intro
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(User canControl: 1 canInput: 1)
		(= global205 0)
		(super dispose:)
	)
)

(instance creditActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((Sound new:) number: 2 loop: 1 play: self)
				(= local1 (View new:))
				(local1
					view: 898
					setPri: 0
					setLoop: 0
					setCel: 0
					x: 162
					y: 78
					init:
				)
				(= [local1 1] (View new:))
				([local1 1]
					view: 898
					setPri: 0
					setLoop: 0
					setCel: 1
					x: 162
					y: 112
					init:
				)
				(= seconds 4)
			)
			(1
				(local1 dispose:)
				([local1 1] dispose:)
				(= [local1 2] (View new:))
				([local1 2]
					view: 898
					setPri: 0
					setLoop: 1
					setCel: 0
					x: 162
					y: 78
					init:
				)
				(= [local1 3] (View new:))
				([local1 3]
					view: 898
					setPri: 0
					setLoop: 1
					setCel: 2
					x: 162
					y: 112
					init:
				)
				(= seconds 3)
			)
			(2
				([local1 2] dispose:)
				(= [local1 4] (View new:))
				([local1 4]
					view: 898
					setPri: 0
					setLoop: 1
					setCel: 1
					x: 162
					y: 78
					init:
				)
				(= seconds 3)
			)
			(3
				([local1 4] dispose:)
				([local1 3] dispose:)
				(= [local1 6] (View new:))
				([local1 6]
					view: 898
					setPri: 0
					setLoop: 2
					setCel: 0
					x: 162
					y: 78
					init:
				)
				(= [local1 5] (View new:))
				([local1 5]
					view: 898
					setPri: 0
					setLoop: 2
					setCel: 1
					x: 162
					y: 100
					init:
				)
				(= [local1 7] (View new:))
				([local1 7]
					view: 898
					setPri: 0
					setLoop: 2
					setCel: 2
					x: 162
					y: 138
					init:
				)
				(= seconds 3)
			)
			(4
				([local1 6] dispose:)
				([local1 7] dispose:)
				([local1 5] dispose:)
				(= [local1 8] (View new:))
				([local1 8]
					view: 899
					setPri: 0
					setLoop: 0
					setCel: 0
					x: 162
					y: 78
					init:
				)
				(= [local1 9] (View new:))
				([local1 9]
					view: 899
					setPri: 0
					setLoop: 0
					setCel: 1
					x: 162
					y: 110
					init:
				)
				(= [local1 10] (View new:))
				([local1 10]
					view: 899
					setPri: 0
					setLoop: 2
					setCel: 0
					x: 162
					y: 146
					init:
				)
				(= seconds 5)
			)
			(5
				([local1 8] dispose:)
				([local1 9] dispose:)
				([local1 10] dispose:)
				(= [local1 11] (View new:))
				([local1 11]
					view: 898
					setPri: 0
					setLoop: 3
					setCel: 0
					x: 162
					y: 78
					init:
				)
				(= [local1 12] (View new:))
				([local1 12]
					view: 898
					setPri: 0
					setLoop: 4
					setCel: 0
					x: 162
					y: 110
					init:
				)
				(= [local1 8] (View new:))
				([local1 8]
					view: 898
					setPri: 0
					setLoop: 3
					setCel: 2
					x: 162
					y: 146
					init:
				)
				(= seconds 4)
			)
			(6
				([local1 11] dispose:)
				([local1 12] dispose:)
				([local1 8] dispose:)
				(= [local1 13] (View new:))
				([local1 13]
					view: 898
					setPri: 0
					setLoop: 3
					setCel: 1
					x: 162
					y: 78
					init:
				)
				(= [local1 14] (View new:))
				([local1 14]
					view: 898
					setPri: 0
					setLoop: 4
					setCel: 1
					x: 162
					y: 112
					init:
				)
				(= seconds 4)
			)
			(7
				([local1 13] dispose:)
				([local1 14] dispose:)
				(= [local1 15] (View new:))
				([local1 15]
					view: 899
					setPri: 0
					setLoop: 1
					setCel: 0
					x: 162
					y: 78
					init:
				)
				(= [local1 16] (View new:))
				([local1 16]
					view: 899
					setPri: 0
					setLoop: 1
					setCel: 1
					x: 162
					y: 110
					init:
				)
				(= [local1 17] (View new:))
				([local1 17]
					view: 899
					setPri: 0
					setLoop: 1
					setCel: 2
					x: 162
					y: 146
					init:
				)
				(= [local1 18] (View new:))
				(= seconds 4)
			)
			(8
				([local1 16] dispose:)
				([local1 17] dispose:)
				([local1 18]
					view: 899
					setPri: 0
					setLoop: 1
					setCel: 3
					x: 162
					y: 110
					init:
				)
				(= [local1 19] (View new:))
				([local1 19]
					view: 899
					setPri: 0
					setLoop: 1
					setCel: 4
					x: 162
					y: 146
					init:
				)
			)
			(9
				([local1 15] dispose:)
				([local1 18] dispose:)
				([local1 19] dispose:)
				(gCurRoom newRoom: 120) ; intro
			)
		)
	)
)

