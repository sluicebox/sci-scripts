;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm051 0
)

(local
	local0
	[local1 2]
	local3
	[local4 22] = [0 189 0 130 130 130 120 159 72 156 104 160 118 163 114 168 88 168 92 175 71 189]
	[local26 8] = [0 85 148 92 135 127 0 128]
	[local34 10] = [0 80 118 70 139 76 147 89 0 82]
	[local44 14] = [0 31 193 45 205 49 194 56 143 64 105 69 0 76]
	[local58 20] = [231 189 240 178 255 178 253 170 240 162 188 161 170 156 174 121 319 121 319 189]
	[local78 8] = [106 180 130 172 154 177 138 184]
	[local86 8] = [173 164 205 164 206 179 175 183]
	[local94 16] = [319 118 172 118 169 83 150 74 240 49 0 14 0 0 319 0]
)

(instance rm051 of KQ5Room
	(properties
		picture 51
		north 52
		south 89
	)

	(method (init)
		(Load rsSCRIPT 941)
		(if (== (gGame detailLevel:) 3)
			(surf1 setScript: waves)
		)
		(if (not (IsFlag 55))
			(= global320 186)
			(= global321 176)
			(= global325 {"Come on, Graham! Let's explore someplace else!"})
		)
		(HandsOn)
		(if (== ((gInventory at: 37) owner:) 51) ; Cat_Fish
			(fishy init: stopUpd: ignoreActors: 1)
		)
		(switch gPrevRoomNum
			(north
				(gEgo view: 0 init: posn: 222 51 setPri: 15 setStep: 3 2)
				(if (not (IsFlag 55))
					(self setRegions: 202) ; owl
					(self setScript: (ScriptID 202 1)) ; stdWalkIn
					(global322 setPri: 14)
				else
					(gEgo setMotion: MoveTo 222 51)
				)
			)
			(else
				(gEgo
					view: 664
					loop: 1
					cel: 0
					posn: 123 171
					setPri: -1
					setStep: 3 2
				)
				(gEgo normal: 0 init:)
				(if (not (IsFlag 55))
					(Cedric init: stopUpd:)
					(board init: stopUpd:)
				)
				(if (IsFlag 112)
					(setUpCode doit:)
					(ClearFlag 112)
				else
					((gEgo head:) view: 0 hide:)
					(self setScript: marooned)
				)
			)
		)
		(poly1 points: @local4 size: 11)
		(poly2 points: @local26 size: 4)
		(poly3 points: @local34 size: 5)
		(poly4 points: @local44 size: 7)
		(poly5 points: @local58 size: 10)
		(poly6 points: @local78 size: 4)
		(poly7 points: @local86 size: 4)
		(poly8 points: @local94 size: 8)
		(sailBoat init: stopUpd:)
		(rubble init:)
		(mast setPri: 11 init: stopUpd:)
		(gGlobalSound number: 831 loop: -1 vol: 127 play:)
		(self
			setFeatures: path51 beach
			addObstacle: poly1 poly2 poly3 poly4 poly5 poly6 poly7 poly8
		)
		(super init:)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((gEgo inRect: 126 87 144 95)
				(gEgo priority: 11 signal: (| (gEgo signal:) $0010))
				((gEgo head:)
					priority: 11
					signal: (| ((gEgo head:) signal:) $0010)
				)
			)
			((== (gCurRoom script:) falling))
			((gEgo inRect: 46 129 125 162)
				(gEgo priority: 12 signal: (| (gEgo signal:) $0010))
				((gEgo head:)
					priority: 12
					signal: (| ((gEgo head:) signal:) $0010)
				)
			)
			(
				(and
					(& (= temp1 (gEgo onControl: 1)) $0004)
					(== (gEgo view:) 0)
				)
				(gEgo view: 26)
			)
			((and (not (& temp1 $0004)) (== (gEgo view:) 26))
				(gEgo view: 0)
			)
			((gEgo inRect: 90 50 180 80)
				(gEgo priority: 5 signal: (| (gEgo signal:) $0010))
				((gEgo head:)
					priority: 5
					signal: (| ((gEgo head:) signal:) $0010)
				)
			)
			((< (gEgo y:) 67)
				(gEgo priority: 6 signal: (| (gEgo signal:) $0010))
				((gEgo head:)
					priority: 6
					signal: (| ((gEgo head:) signal:) $0010)
				)
			)
			((> (gEgo y:) 67)
				(gEgo priority: -1 signal: (& (gEgo signal:) $ffef))
				((gEgo head:)
					priority: -1
					signal: (& ((gEgo head:) signal:) $ffef)
				)
			)
		)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(HandsOff)
				(gCurRoom setScript: leaveSouth)
			)
			((& (gEgo onControl: 0) $4000)
				(HandsOff)
				(self setScript: leave)
			)
			((& (gEgo onControl: 1) $3400)
				(self setScript: falling)
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

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gGlobalSound fade:)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance leaveSouth of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (gCast contains: global322)
					(proc0_28 75 51 0 67 10 10 25 5) ; "I think I'll stay here until you come back."
				)
				(= cycles 1)
			)
			(1
				(gEgo setPri: -1 setMotion: PolyPath (gEgo x:) 220 self)
			)
			(2
				(gCurRoom newRoom: 89)
			)
		)
	)
)

(instance leave of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (- (gEgo x:) 10) 36 self)
			)
			(1
				(if (not (gCast contains: global322))
					(gCurRoom newRoom: 52)
				else
					(global322 setScript: 0)
					(if (gCast contains: global322)
						(global322 view: 138 loop: 5 setCycle: End self)
					)
				)
			)
			(2
				(global322 loop: 9 setCycle: End self)
			)
			(3
				(HandsOn)
				(gCurRoom newRoom: 52)
				(client setScript: 0)
			)
		)
	)
)

(instance waves of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(surf1
					init:
					show:
					setCycle: End self
					setPri: 11
					ignoreActors:
					cycleSpeed: 10
				)
				(surf2
					init:
					setCycle: RandCycle
					setPri: 11
					ignoreActors:
					cycleSpeed: 10
				)
				(surf3
					init:
					setCycle: RandCycle
					setPri: 11
					ignoreActors:
					cycleSpeed: 10
				)
				(surf4
					init:
					setCycle: RandCycle
					setPri: 11
					ignoreActors:
					cycleSpeed: 10
				)
			)
			(1
				(surf1 setCycle: Beg self)
				(surf2 setCycle: Beg)
				(surf3 setCycle: Beg)
				(surf4 setCycle: Beg)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance marooned of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 5)
			)
			(1
				(gEgo loop: 1 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 15)
			)
			(2
				(gEgo loop: 2 setCycle: End self)
			)
			(3
				(if (not (IsFlag 55))
					(proc0_28 75 51 1 67 50 20 25 4) ; "Help me, I'm caught! Oh, help!"
					(Cedric
						cycleSpeed: 3
						ignoreActors: 1
						setPri: -1
						illegalBits: 0
						setCycle: Fwd
					)
					(= cycles 1)
				else
					(gEgo view: 0 loop: 3 init:)
					((gEgo head:) show:)
					(NormalEgo)
					(HandsOn)
					(client setScript: 0)
				)
			)
			(4
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					cycleSpeed: 0
					illegalBits: 0
					setCycle: KQ5SyncWalk
					setMotion: MoveTo 162 173 self
				)
			)
			(5
				(cls)
				(Cedric hide:)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 664
					posn: 186 176
					loop: 9
					setPri: -1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(6
				(proc0_28 160 51 2 67 20 20 25 4) ; "Are you all right, Cedric?"
				(gEgo
					normal: 1
					view: 0
					posn: 162 173
					loop: 2
					cel: 0
					illegalBits: -32768
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(Cedric show: loop: 4 cel: 0 setCycle: End self)
			)
			(7
				(proc0_28 75 51 3 67 50 20 25 3) ; "Well, let me see..."
				(Cedric loop: 11 cel: 0 setPri: 14 setCycle: End self)
			)
			(8
				(proc0_28 75 51 4 67 50 20 25 7) ; "I'm fine, Graham. Just a bit ruffled, is all."
				(Cedric ignoreActors: 0 loop: 4 cel: 5 stopUpd:)
				(= cycles 1)
			)
			(9
				(cls)
				(setUpCode doit:)
				(client setScript: 0)
			)
		)
	)
)

(instance setUpCode of Code
	(properties)

	(method (doit)
		(cls)
		(if (not (IsFlag 55))
			(Cedric hide:)
			(gCurRoom setRegions: 202) ; owl
		)
		((gEgo head:) view: 0 moveHead: 1 loop: 4 setLoop: -1)
		(gEgo
			normal: 1
			view: 0
			posn: 162 173
			loop: 2
			cel: 0
			illegalBits: -32768
			cycleSpeed: 0
			setCycle: KQ5SyncWalk
		)
		(gEgo setLoop: -1 normal: 1)
		(SetScore 3)
		(HandsOn)
	)
)

(instance falling of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(> (gEgo y:) 85)
				(!= (gEgo view:) 0)
				(> (gEgo cel:) 2)
				(< (gEgo loop:) 2)
			)
			(gEgo setPri: 2)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo normal: 0)
				(if (gCast contains: global322)
					(proc0_28 75 51 5 67 20 20 25 3) ; "No, don't...!"
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((& (gEgo onControl: 1) $1000)
						(= register 0)
					)
					((& (gEgo onControl: 1) $2000)
						(= register 1)
					)
					((& (gEgo onControl: 1) $0400)
						(if (gEgo inRect: 130 45 190 65)
							(= register 0)
						else
							(= register 1)
						)
					)
				)
				(= cycles 1)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 68
					setLoop: (if register 0 else 1)
					cel: 0
					setStep: 4 8
					cycleSpeed: 1
					setCycle: End self
					setPri:
						(cond
							((gEgo inRect: 130 45 190 65) 2)
							((< (gEgo y:) 45) 1)
							((< (gEgo y:) 88) 2)
							(else 11)
						)
					illegalBits: 0
				)
				(if (== register 0)
					(gEgo x: (- (gEgo x:) 10))
				else
					(gEgo x: (+ (gEgo x:) 10))
				)
				(gGlobalSound3 number: 60 loop: 1 play:)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) 105 self)
			)
			(4
				(gGlobalSound3 number: 892 loop: 1 play:)
				(gEgo loop: (+ (gEgo loop:) 2))
				(= seconds 3)
			)
			(5
				(= global330 {That last step was a doozy!})
				(EgoDead)
			)
			(6
				(HandsOn)
				(gEgo posn: 160 160 view: 0)
				(NormalEgo)
				(client setScript: 0)
			)
		)
	)
)

(instance getFish of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 113 159 self)
			)
			(1
				(proc0_28 160 51 6 67 20 20 25 4) ; "Yech! A dead fish. Well, maybe I can use it."
				(= cycles 1)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					view: 56
					loop: 0
					ignoreActors:
					normal: 0
					setCycle: End self
				)
			)
			(3
				(SetScore 2)
				(gEgo get: 37) ; Cat_Fish
				(fishy dispose:)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo view: 0 setPri: -1 normal: 1)
				((gEgo head:) show:)
				(NormalEgo)
				(= cycles 1)
			)
			(6
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance island of RFeature ; UNUSED
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 51 7) ; "An involuntary shiver runs down Graham's spine as an overpowering sense of evil seems to hang over this island like a smothering mantle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance path51 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 51 8) ; "A crude set of stairs has been carved into the rocky cliffs of Mordack's island. Above them, a narrow, winding trail leads on up to his castle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance beach of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 51 9) ; "Although very cold, the waters here are calm due to a protective reef. The small beach, however, is nothing but rocks and coarse, almost gravelly, sand."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance board of View
	(properties
		x 186
		y 176
		view 664
		loop 10
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 51 10) ; "Oh, dear! Now what?! Poor Graham's boat has been dashed to pieces against the jagged rocks of Mordack's island and is now completely useless."
					(event claimed: 1)
				)
				(3 ; Do
					(if (and (not (IsFlag 55)) (not local0))
						(++ local0)
						(PrintDC 51 11) ; "Unfortunately nothing can be done about the wrecked boat. It appears that Graham is stuck here."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance sailBoat of View
	(properties
		x 62
		y 180
		view 664
		cel 2
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 51 10) ; "Oh, dear! Now what?! Poor Graham's boat has been dashed to pieces against the jagged rocks of Mordack's island and is now completely useless."
					(event claimed: 1)
				)
				(3 ; Do
					(if (and (not (IsFlag 55)) (not local0))
						(++ local0)
						(PrintDC 51 11) ; "Unfortunately nothing can be done about the wrecked boat. It appears that Graham is stuck here."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance mast of View
	(properties
		x 244
		y 182
		view 664
		cel 4
		signal 16384
	)

	(method (handleEvent event)
		(if (gCast contains: global322)
			(global322 handleEvent: event)
		)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 51 10) ; "Oh, dear! Now what?! Poor Graham's boat has been dashed to pieces against the jagged rocks of Mordack's island and is now completely useless."
					(event claimed: 1)
				)
				(3 ; Do
					(if (and (not (IsFlag 55)) (not local0))
						(++ local0)
						(PrintDC 51 11) ; "Unfortunately nothing can be done about the wrecked boat. It appears that Graham is stuck here."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance rubble of RPicView
	(properties
		x 76
		y 163
		view 664
		cel 3
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 51 10) ; "Oh, dear! Now what?! Poor Graham's boat has been dashed to pieces against the jagged rocks of Mordack's island and is now completely useless."
					(event claimed: 1)
				)
				(3 ; Do
					(if (and (not (IsFlag 55)) (not local0))
						(++ local0)
						(PrintDC 51 11) ; "Unfortunately nothing can be done about the wrecked boat. It appears that Graham is stuck here."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance Cedric of Actor
	(properties
		x 186
		y 176
		view 664
		loop 3
		signal 16384
		detailLevel 3
	)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 51 12) ; "A bit shaken, Cedric anxiously takes stock of their unsure situation."
					(event claimed: 1)
				)
				(5 ; Talk
					(if (not local3)
						(proc0_28 75 51 13 67 10 10 25 8) ; "I hate to say this, Graham, but...I don't like this place at all!"
						(proc0_28 160 51 14 67 10 10 25 5) ; "I know what you mean, Cedric."
						(= local3 1)
						(event claimed: 1)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance fishy of Prop
	(properties
		x 108
		y 154
		view 664
		loop 10
		cel 1
		detailLevel 3
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 51 15) ; "A dead fish lies on the rocky beach at the foot of the stairs."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getFish)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wave1 of Prop ; UNUSED
	(properties
		x 44
		y 169
		view 664
		loop 5
		detailLevel 3
	)
)

(instance wave2 of Prop ; UNUSED
	(properties
		x 32
		y 188
		view 664
		loop 6
		detailLevel 3
	)
)

(instance wave3 of Prop ; UNUSED
	(properties
		x 124
		y 188
		view 664
		loop 7
		detailLevel 3
	)
)

(instance wave4 of Prop ; UNUSED
	(properties
		x 255
		y 188
		view 664
		loop 8
		detailLevel 3
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly6 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly7 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly8 of Polygon
	(properties)
)

(instance surf1 of Prop
	(properties
		x 34
		y 189
		view 664
		loop 5
		detailLevel 3
	)
)

(instance surf2 of Prop
	(properties
		x 112
		y 189
		view 664
		loop 6
		detailLevel 3
	)
)

(instance surf3 of Prop
	(properties
		x 226
		y 189
		view 664
		loop 6
		detailLevel 3
	)
)

(instance surf4 of Prop
	(properties
		x 292
		y 189
		view 664
		loop 6
		detailLevel 3
	)
)

