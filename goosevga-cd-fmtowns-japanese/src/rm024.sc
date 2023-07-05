;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm024 0
)

(local
	[local0 59] = [3 0 0 0 0 -14078 93 230 92 214 89 201 82 201 75 206 71 206 58 256 -32756 -14172 0 164 77 182 85 196 86 207 96 203 101 179 101 161 106 152 104 152 -32768 -14305 83 147 97 147 107 124 117 65 117 36 108 8 115 8 -32637 0 0]
)

(instance rm024 of Rm
	(properties
		picture 24
		style 0
		north 17
		east 25
		south 31
		west 23
	)

	(method (init &tmp [temp0 3])
		(Load rsVIEW 129)
		(super init:)
		(door init: ignoreActors: stopUpd:)
		(proc0_1)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(41
				(gEgo loop: 0 posn: 161 107 init:)
				(self setScript: closeDoorScript)
			)
			(north
				(gEgo posn: 197 82)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 global63 (gEgo x:) global62) 150)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 10 (proc0_13 137 (gEgo y:) global61))
				(if (and global130 (<= global130 47))
					(global129 observeControl: 128)
				)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(east
				(gEgo
					posn:
						250
						(proc0_13 88 (proc0_14 130 (gEgo y:) 137) global61)
				)
				(if (and global130 (<= global130 47))
					(if (< (gEgo y:) 134)
						(global129 observeControl: 256)
					else
						(global129 observeControl: 128)
					)
				)
				(self setScript: gStdWalkIn)
			)
			(else
				(gEgo posn: 126 118 init:)
			)
		)
		(proc0_8 226 100)
		(cuckoo init:)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(script
				(script doit:)
			)
			((== gScore gPossibleScore)
				(++ gScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((& (gEgo onControl:) $2000)
				(self newRoom: north)
			)
			((& (gEgo onControl:) $4000)
				(self setScript: openDoorScript)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(Timer set60ths: self (DoAudio audPLAY 38))
				(= cycles 10)
			)
			(1
				(door setCycle: End self)
			)
			(2)
			(3
				(gCurRoom newRoom: 41)
			)
		)
	)
)

(instance closeDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(door setCel: -1 startUpd: setCycle: Beg self)
				(= cycles 4)
			)
			(1
				(DoAudio audPLAY 36)
			)
			(2
				(door stopUpd:)
				(if (== gScore gPossibleScore)
					(proc0_2)
				else
					(proc0_3)
				)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 129
			ignoreActors: 1
			setPri: 7
			setLoop: 0
			setCel: (if (== gPrevRoomNum 41) 4 else 0)
			cycleSpeed: 1
			posn: 139 103
		)
	)
)

(instance cuckoo of Prop
	(properties
		y 27
		x 174
		view 129
		loop 1
		priority 12
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if (proc0_18 self event)
			(event claimed: 1)
			(if (== (cuckooScript state:) 0)
				(cuckooScript changeState: 1)
			)
		)
	)

	(method (init)
		(super init:)
		(self setScript: cuckooScript stopUpd:)
	)
)

(instance cuckooScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> global170 70)
					(= seconds (Random 8 15))
				)
			)
			(1
				(DoAudio audPLAY 583)
				(cuckoo setCycle: End self)
			)
			(2
				(cuckoo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(cuckoo setCycle: Beg self)
			)
			(4
				(cuckoo setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(5
				(cuckoo stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

