;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm024 0
)

(local
	local0
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
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 297 38 290 98 207 82 208 67
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 35 170 56 183 75 198 92 200 99 159 101 156 60 135 61 139 102 132 111 111 115 87 116 32 107 3 112 4 128 288 128 281 137 0 137
					yourself:
				)
		)
		(door init: ignoreActors: stopUpd:)
		(NormalEgo)
		(switch gPrevRoomNum
			(41
				(= global345 outCode1)
				(gEgo loop: 0 posn: 161 107 init:)
				(self setScript: closeDoorScript)
			)
			(north
				(= global345 outCode1)
				(gEgo posn: 197 82)
				(self setScript: gStdWalkIn)
			)
			(south
				(= global345 outCode2)
				(gEgo posn: (proc0_13 global61 (gEgo x:) global60) 139)
				(self setScript: gStdWalkIn)
			)
			(west
				(= global345 outCode2)
				(gEgo posn: 26 (proc0_13 137 (gEgo y:) global59))
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
						231
						(proc0_13 88 (proc0_14 130 (gEgo y:) 137) global59)
				)
				(if (<= (gEgo y:) 130)
					(= global345 outCode1)
				else
					(= global345 outCode2)
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
				(= global345 outCode1)
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

	(method (dispose)
		(super dispose: &rest)
		(gLongSong pause: 0)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSfx number: 38 play: self)
				(door setCycle: End self)
			)
			(1
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
				(HandsOff)
				(door startUpd: setCycle: Beg self)
				(gSfx number: 36 play:)
			)
			(1
				(door stopUpd:)
				(if (== gScore gPossibleScore)
					(HandsOff)
				else
					(HandsOn)
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
			cycleSpeed: 6
			posn: 139 103
		)
	)

	(method (dispose)
		(super dispose:)
		(self addToPic:)
	)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance cuckoo of Prop
	(properties
		x 174
		y 27
		view 129
		loop 1
		priority 12
		cycleSpeed 6
	)

	(method (doVerb)
		(if (== (cuckooScript state:) 0)
			(cuckooScript changeState: 1)
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
				(= seconds 0)
				(gLongSong pause: 1)
				(if global157
					(DoAudio audPLAY 583)
				else
					(gSfx number: 583 play:)
				)
				(cuckoo startUpd: setCycle: End self)
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
				(gLongSong pause: 0)
				(cuckoo stopUpd:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 160 (gEgo x:) 220))
				(= temp1 39)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 93 (gEgo y:) 126))
			)
			(3
				(= temp0 (proc0_13 6 (gEgo x:) 260))
				(= temp1 130)
			)
			(4
				(= temp0 3)
				(= temp1 (proc0_13 112 (gEgo y:) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

(instance outCode2 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 4 (gEgo x:) 255))
				(= temp1 136)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 138 (gEgo y:) 155))
			)
			(3
				(= temp0 (proc0_13 1 (gEgo x:) 257))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 138 (gEgo y:) 155))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

