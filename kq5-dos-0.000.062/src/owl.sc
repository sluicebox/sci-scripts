;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	owl 0
	stdWalkIn 1
	stdWalkOut 2
	rotate 3
	cedric 4
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 19] = [2 6 7 8 10 11 12 27 29 30 31 35 44 45 46 52 53 54 -1]
	[local24 19] = [0 2 4 6 100 100 8 9 11 100 100 12 100 100 13 100 100 100 -1]
	[local43 19] = [{Cedric keeps his eye on Graham while perched on a nearby tree branch.} {Cedric keeps an eye on Graham near the town bakehouse.} {Cedric waits for Graham in a nearby tree.} {Cedric perches nervously on a tree limb at the edge of a gloomy forest.} {Cedric eyes Graham impatiently from the gnomes' roof.} {Not being much of a honey eater, Cedric shows little interest in the beehive.} {Cedric perches safely on a scrubby bush above the anthill and watches the activity below.} {Cedric perches upon the "Swarthy Hog Inn" sign.} {Even Cedric looks cold as he watches Graham traverse the icy path.} {Shivering with the cold, Cedric seems to be a bit befuddled, and not much help.} {Shivering with the cold, Cedric seems to be a bit befuddled, and not much help.} {Shivering with the cold, Cedric looks more than ready to leave these frozen reaches behind.} {Cedric looks relieved to be out of those cold mountains.} {Cedric looks with wonder at the beautiful beach.} {Cedric seems as curious about this place as Graham.} {Cedric looks frightened at the sight of the stone serpents.} {Cedric looks more and more frightened the closer he and Graham get to the bizarre castle.} {Cedric perches nervously as he surveys the surrounding area.} {Cedric waits impatiently for Graham.}]
	[local62 14] = [{"See how the path goes to the east up into the mountains? That's the route to Mordack's castle."} {"If you follow the path to the south over the next rise you'll come to the town."} {"See the road there? Back to the east is the town."} {"You'll find a run-down inn if you follow the road to the west."} {"If you walk to the south you'll run into the town bakehouse."} {"There's nothing but a dark, scary forest to the north."} {"Back to the east is Crispin's house."} {"That's a dark, creepy forest that we ALL avoid! I've heard you can get lost in there; and maybe run into an evil old WITCH!"} {"Oh, Graham, that dog looks mean!"} {"Back down the road to the east you'll run into the bakehouse."} {"There's nothing to the west but endless desert."} {"I've never been here before, but I think this is the way over the mountains."} {"Let's go, Graham! I'm cold and I want to get out of here!"} {"Isn't this a funny house, Graham? What kind of person would live in a place like this?"}]
)

(instance owl of Rgn
	(properties)

	(method (init)
		(super init:)
		(= local1 138)
		(if
			(or
				(== gCurRoomNum 29)
				(== gCurRoomNum 30)
				(== gCurRoomNum 27)
				(== gCurRoomNum 1)
				(== gCurRoomNum 52)
			)
			(= local1 140)
			(cedric view: 136)
		else
			(cedric view: 137)
		)
		(cedric
			ignoreHorizon: 1
			setPri: 14
			loop: 8
			cel: 0
			setCycle: Walk
			ignoreActors: 1
			posn: global320 global321
			init:
		)
		(if (or (== gCurRoomNum 9) (== gCurRoomNum 32) (== gCurRoomNum 30))
			(cedric setPri: -1)
		)
		(if (or (== ((gInventory at: 16) owner:) 12) (not (gEgo has: 16))) ; Stick, Stick
			(= [local62 8] {"There's nothing to the west but endless desert."})
		)
		(= global322 cedric)
		(self setScript: messageTime)
	)

	(method (doit)
		(cond
			((== global322 50)
				(= global322 cedric)
				(= [local62 8]
					{"There's nothing to the west but endless desert."}
				)
			)
			(script
				(script doit:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance messageTime of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (or (gCurRoom script:) (== (User controls:) 0))
			(= state -1)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 120 240))
			)
			(1
				(if global322
					(Say 75 global325)
				)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rotate of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if (!= (client loop:) 2)
					(client
						cycleSpeed: 0
						cel: (if (< (client loop:) 2) 4 else 7)
						loop: (if (== (client loop:) 0) 5 else 4)
						setCycle: CT 0 -1 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== (client view:) 138)
					(= temp2 137)
				else
					(= temp2 136)
				)
				(= local1 (client view:))
				(= local2 (client loop:))
				(= local3 (client cel:))
				(client view: temp2 loop: 8 cycleSpeed: 3 cel: 2)
				(= cycles 1)
			)
			(2
				(cond
					((> (= temp1 (Random 0 4)) (client cel:))
						(= temp0 1)
					)
					((< temp1 (client cel:))
						(= temp0 -1)
					)
					((== temp1 4)
						(-- temp1)
						(= temp0 -1)
					)
					(else
						(++ temp1)
						(= temp0 1)
					)
				)
				(client setCycle: CT temp1 temp0)
				(-- state)
				(= seconds (Random 5 10))
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance stdWalkIn of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 2])
		(switch (= state newState)
			(0
				(if
					(or
						(== gCurRoomNum 29)
						(== gCurRoomNum 30)
						(== gCurRoomNum 27)
						(== gCurRoomNum 1)
						(== gCurRoomNum 52)
					)
					(cedric view: 140)
				else
					(cedric view: 138)
				)
				(gEgo edgeHit: EDGE_NONE)
				(HandsOff)
				(= register (gCurRoom roomToEdge: gPrevRoomNum))
				(= temp5
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp4
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp2 (gEgo x:))
				(= temp3 (gEgo y:))
				(switch register
					(3
						(= temp0 temp2)
						(= temp1 (+ global61 temp5))
						(= temp6 3)
					)
					(2
						(= temp1 temp3)
						(= temp0 (+ global62 temp4))
						(= temp6 1)
					)
					(4
						(= temp1 temp3)
						(= temp0 (- global63 temp4))
						(= temp6 0)
					)
					(1
						(= temp0 temp2)
						(= temp1 (- temp3 2))
						(= temp6 2)
					)
				)
				(gEgo
					posn: temp0 temp1
					init:
					setLoop: -1
					ignoreActors: 1
					setMotion: MoveTo temp2 temp3
				)
				(cedric loop: temp6 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(1
				(cedric setScript: rotate)
				(= cycles 1)
			)
			(2
				(if (gEgo mover:)
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(gEgo ignoreActors: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance stdWalkOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(HandsOff)
				(cedric view: local1 loop: local2 cel: local3 setScript: 0)
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(= temp3 5)
				(switch register
					(1
						(-= temp1 10)
						(= temp2 7)
					)
					(3
						(+= temp1 60)
						(= temp2 0)
					)
					(2
						(+= temp0 20)
						(= temp2 4)
					)
					(4
						(-= temp0 20)
						(= temp2 4)
						(= temp3 4)
					)
				)
				(if (!= temp2 0)
					(cedric loop: temp3 cycleSpeed: 0 setCycle: CT temp2 1 self)
				else
					(= cycles 1)
				)
				(if (!= register 1)
					(gEgo ignoreActors: 1 setMotion: MoveTo temp0 temp1)
				else
					(gEgo loop: 3)
				)
			)
			(1
				(if (== register 1)
					(cedric cycleSpeed: 1 loop: 9 cel: 0 setCycle: CT 4 1 self)
				else
					(cedric
						cycleSpeed: 1
						loop:
							(switch register
								(2 6)
								(4 7)
								(else 8)
							)
						cel: 0
						setCycle: End self
					)
				)
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: (gCurRoom edgeToRoom: register))
			)
		)
	)
)

(class regOwl of Act
	(properties
		speak 0
	)
)

(instance cedric of regOwl
	(properties
		view 138
		illegalBits 0
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(= temp1 0)
			(switch (event message:)
				(2 ; Look
					(for ((= temp0 0)) (<= temp0 17) ((++ temp0))
						(if (== gCurRoomNum [local5 temp0])
							(= temp1 1)
							(PrintDC [local43 temp0])
							(break)
							(return)
						)
					)
					(if (not temp1)
						(PrintDC [local43 temp0])
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 202 0) ; "Cedric doesn't need anything at the moment."
							(event claimed: 1)
						)
					)
				)
				(4 ; Talk
					(for ((= temp0 0)) (<= temp0 15) ((++ temp0))
						(if (== gCurRoomNum [local5 temp0])
							(= temp1 [local24 temp0])
							(= temp2 [local24 (+ temp0 1)])
							(if
								(and
									(== local4 1)
									(or (== temp2 100) (== (- temp2 temp1) 1))
								)
								(= temp1 0)
								(break)
							)
							(if (or (== temp1 100) (== local4 2))
								(= temp1 0)
								(break)
							else
								(Say 75 [local62 (+ local4 temp1)])
								(event claimed: 1)
								(++ local4)
								(return)
							)
						)
					)
					(if (not temp1)
						(switch (Random 0 3)
							(0
								(PrintDC 202 1) ; "Cedric isn't listening to Graham at the moment."
							)
							(1
								(PrintDC 202 2) ; "Cedric isn't paying any attention to Graham."
							)
							(2
								(PrintDC 202 3) ; "Cedric isn't in the mood to talk right now."
							)
							(else
								(PrintDC 202 4) ; "Cedric doesn't have anything important to say at the moment."
							)
						)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

