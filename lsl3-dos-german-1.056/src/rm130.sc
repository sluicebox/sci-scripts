;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm130 0
)

(local
	pixelsPerFloor
	numberOfFloors
	houseCount
	[houseXY 42] = [158 73 172 73 185 73 197 73 205 65 192 65 178 65 166 65 151 66 140 59 150 59 160 59 171 59 184 59 196 59 189 51 180 51 171 51 162 51 153 51 999 999]
)

(procedure (BuildHouse)
	(aHouse setPri: 1 posn: [houseXY (++ houseCount)] [houseXY (++ houseCount)])
	(AddActorToPic aHouse)
	(if (== 999 [houseXY houseCount])
		(-= houseCount 2)
	)
)

(procedure (AddBuildingToPic)
	(aBuilding posn: (aBuilding x:) (+ 1000 (aBuilding y:)))
	(aWorkers posn: 999 999)
	((View new:)
		view: (aBuilding view:)
		setLoop: (aBuilding loop:)
		setCel: (aBuilding cel:)
		setPri: 3
		posn: (aBuilding x:) (- (- (aBuilding y:) 1000) pixelsPerFloor)
		ignoreActors: 1
		addToPic:
	)
)

(procedure (ChangeFloors)
	(aBuilding posn: (aBuilding x:) (- (aBuilding y:) pixelsPerFloor))
	(aWorkers
		posn: (aWorkers x:) (- (aWorkers y:) pixelsPerFloor)
		cel: 0
		setCycle: End RoomScript
	)
)

(instance rm130 of Rm
	(properties
		picture 130
		horizon 1
	)

	(method (init)
		(HandsOff)
		(SetFlag 3)
		(SetFlag 5)
		(super init:)
		(self setScript: RoomScript)
		(gGame setSpeed: 6)
		(aBuilding init:)
		(aWorkers init:)
		(aHouse init:)
		(= houseCount -1)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:))
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_F2))
				(TglSound)
			)
			((and gModelessDialog (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
				(event claimed: 1)
				(cls)
			)
			(else
				(gCurRoom newRoom: 140)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Print 130 0 #at 10 5 #width 290 #time (LangSwitch 12 12 24 24)) ; "Since we last saw our intrepid hero Larry Laffer cavorting merrily with his newly-found true love on the sands of Nontoonyt Beach, this beautiful island has undergone extensive "improvements.""
				(= seconds 3)
			)
			(2
				(Print 130 1 #at 10 5 #width 290 #time (LangSwitch 16 16 32 32)) ; "Once pristine and primitive, covered by virgin rain forest, splashed by gurgling streams and washed by tropical rains, Nontoonyt has discovered (and been discovered by) modern civilization."
				(= seconds 3)
			)
			(3
				(PrintSplit 130 2 67 10 5 70 290 25 22) ; "The villagers, eager to shed their Stone Age lifestyle, united themselves by forming "Natives, Inc.\05" to protect their interests and develop their island. Realizing they were sitting on a yuppie dream, a vein of gold they could mine through tourism, they took correspondence courses in business management, public administration, sales and marketing."
				(= seconds 3)
			)
			(4
				(Print 130 3 #at -1 120 #width 280 #dispose #time (LangSwitch 9 9 18 18)) ; "Learning modern construction techniques through self-help books and pirated videotapes of "This Old House," they began by building a hotel on this very same beach."
				(= seconds 7)
			)
			(5
				(= pixelsPerFloor 16)
				(= numberOfFloors 6)
				(aBuilding setCel: 0 posn: 22 117)
				(aWorkers setLoop: 1 cel: 0 posn: 22 117 setCycle: End self)
			)
			(6
				(ChangeFloors)
				(if (-- numberOfFloors)
					(-- state)
				)
			)
			(7
				(AddBuildingToPic)
				(Print 130 4 #at -1 120 #width 280 #dispose #time 7) ; "Borrowing heavily from foreign investors, they expanded into some very attractive tourist traps..."
				(= cycles 15)
			)
			(8
				(BuildHouse)
				(= pixelsPerFloor 13)
				(= numberOfFloors 6)
				(aBuilding setCel: 1 posn: 55 116)
				(aWorkers setLoop: 2 cel: 0 posn: 55 116 setCycle: End self)
			)
			(9
				(ChangeFloors)
				(if (-- numberOfFloors)
					(-- state)
				)
				(if (== numberOfFloors 3)
					(BuildHouse)
				)
			)
			(10
				(BuildHouse)
				(AddBuildingToPic)
				(= cycles 15)
			)
			(11
				(BuildHouse)
				(= pixelsPerFloor 8)
				(= numberOfFloors 6)
				(aBuilding setCel: 2 posn: 73 116)
				(aWorkers setLoop: 3 cel: 0 posn: 73 116 setCycle: End self)
			)
			(12
				(ChangeFloors)
				(if (-- numberOfFloors)
					(-- state)
				)
				(if (== numberOfFloors 3)
					(BuildHouse)
				)
			)
			(13
				(BuildHouse)
				(AddBuildingToPic)
				(= cycles 15)
			)
			(14
				(BuildHouse)
				(= pixelsPerFloor 11)
				(= numberOfFloors 6)
				(aBuilding setCel: 3 posn: 96 114)
				(aWorkers setLoop: 4 cel: 0 posn: 96 114 setCycle: End self)
			)
			(15
				(ChangeFloors)
				(if (-- numberOfFloors)
					(-- state)
				)
				(if (== numberOfFloors 3)
					(BuildHouse)
				)
			)
			(16
				(BuildHouse)
				(AddBuildingToPic)
				(= cycles 15)
			)
			(17
				(BuildHouse)
				(= pixelsPerFloor 7)
				(= numberOfFloors 5)
				(aBuilding setCel: 4 posn: 127 110)
				(aWorkers setLoop: 5 cel: 0 posn: 127 110 setCycle: End self)
			)
			(18
				(ChangeFloors)
				(if (-- numberOfFloors)
					(-- state)
				)
				(if (== numberOfFloors 3)
					(BuildHouse)
				)
			)
			(19
				(BuildHouse)
				(AddBuildingToPic)
				(PrintSplit 130 5 67 -1 120 70 280 25 (LangSwitch 9 9 18 18)) ; "...but growth really exploded when they discovered the Holy Grail of modern marketing: the wonder of time-share!"
				(= cycles 15)
			)
			(20
				(BuildHouse)
				(= pixelsPerFloor 8)
				(= numberOfFloors 6)
				(aBuilding setCel: 5 posn: 162 108)
				(aWorkers setLoop: 6 cel: 0 posn: 162 108 setCycle: End self)
			)
			(21
				(ChangeFloors)
				(if (-- numberOfFloors)
					(-- state)
				)
				(if (== numberOfFloors 3)
					(BuildHouse)
				)
			)
			(22
				(BuildHouse)
				(AddBuildingToPic)
				(= cycles 15)
			)
			(23
				(BuildHouse)
				(= pixelsPerFloor 8)
				(= numberOfFloors 6)
				(aBuilding setCel: 5 posn: 193 108)
				(aWorkers setLoop: 6 cel: 0 posn: 193 108 setCycle: End self)
			)
			(24
				(ChangeFloors)
				(if (-- numberOfFloors)
					(-- state)
				)
			)
			(25
				(AddBuildingToPic)
				(= cycles 15)
			)
			(26
				(BuildHouse)
				(= pixelsPerFloor 8)
				(= numberOfFloors 6)
				(aBuilding setCel: 5 posn: 224 108)
				(aWorkers setLoop: 6 cel: 0 posn: 224 108 setCycle: End self)
			)
			(27
				(ChangeFloors)
				(if (-- numberOfFloors)
					(-- state)
				)
			)
			(28
				(BuildHouse)
				(AddBuildingToPic)
				(Print 130 6 #at -1 120 #width 280 #dispose #time (LangSwitch 9 9 18 18)) ; "Ah, civilization! Who would want real palm trees when you never have to prune or water those new plastic models?"
				(= cycles 15)
			)
			(29
				(= pixelsPerFloor 0)
				(aBuilding
					setLoop: 7
					cel: 0
					cycleSpeed: 1
					posn: 256 107
					setCycle: End self
				)
			)
			(30
				(BuildHouse)
				(AddBuildingToPic)
				(= cycles 15)
			)
			(31
				(aBuilding setLoop: 8 cel: 0 posn: 286 107 setCycle: End self)
			)
			(32
				(BuildHouse)
				(AddBuildingToPic)
				(= cycles 15)
			)
			(33
				(aBuilding setLoop: 8 cel: 0 posn: 312 113 setCycle: End self)
			)
			(34
				(AddBuildingToPic)
				(= cycles 15)
			)
			(35
				(cls)
				(PrintSplit 130 7 67 -1 120 70 280 25 (LangSwitch 12 12 24 24)) ; "Welcome to the paradise of the Pacific: the all-new, all-improved, totally-yuppiefied, "consumer-orientationalized" Nontoonyt Island!"
				(= cycles 15)
			)
			(36
				(gMusic fade:)
				(= seconds 6)
			)
			(37
				(cls)
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance aWorkers of Act
	(properties
		y 1174
		x 23
		view 130
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setLoop: 1 setPri: 4 ignoreActors: ignoreHorizon:)
	)
)

(instance aBuilding of Act
	(properties
		y 999
		x 23
		view 130
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 setPri: 3 ignoreActors: ignoreHorizon:)
	)
)

(instance aHouse of Prop
	(properties
		y 999
		x 999
		view 130
		loop 9
	)
)

