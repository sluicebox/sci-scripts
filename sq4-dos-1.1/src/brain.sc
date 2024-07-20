;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 704)
(include sci.sh)
(use Main)
(use Interface)
(use RegionPath)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	brain 0
	droid1 1
	droid2 2
	terminal1 3
	terminal2 4
	terminal3 5
	proc704_6 6
	timerSound 7
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	[local12 100]
	[local112 40]
	[local152 271] = [32767 515 23 170 166 170 207 124 340 124 32767 520 -20 124 53 124 104 143 203 143 255 124 340 124 32767 525 -20 124 69 124 -20 -18 32767 510 158 240 106 161 -20 161 32767 505 340 163 65 163 255 163 271 240 32767 520 230 130 230 172 92 172 49 152 -20 152 32767 515 340 154 135 154 117 166 79 166 61 73 96 73 177 -8 32767 500 63 240 173 120 340 120 32767 505 -20 124 44 124 78 31 44 124 -20 124 32767 500 340 120 173 120 63 240 32767 515 177 -18 136 34 340 34 32767 520 -20 34 91 34 111 22 204 22 233 34 340 34 32767 525 -20 34 140 34 95 -18 32767 510 267 240 147 120 -20 120 32767 505 340 124 271 124 236 31 271 124 340 124 32767 510 -20 120 147 120 267 240 32767 525 105 -18 140 34 227 34 340 111 340 180 203 180 124 91 -20 91 32767 520 340 91 241 91 209 103 103 103 81 91 -20 91 32767 515 340 91 77 91 96 73 61 73 79 166 117 166 135 154 340 154 32767 520 -20 152 78 152 78 124 32767 505 42 240 65 163 340 163 32767 510 -20 161 106 161 158 240 32767 525 -20 -18 69 124 -20 124 32767 520 340 124 255 124 203 143 104 143 53 124 -20 124 32767 515 340 124 207 124 166 170 23 170 -32768]
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(cond
		((< (= temp0 ((param1 mover:) value:)) 50)
			(= temp1 2)
		)
		((< temp0 72)
			(= temp1 1)
		)
		((< temp0 208)
			(= temp1 3)
		)
		((< temp0 224)
			(= temp1 1)
		)
		(else
			(= temp1 2)
		)
	)
	(return temp1)
)

(procedure (localproc_1 &tmp temp0)
	(switch (= temp0 (brain formatting:))
		(5000
			(StrCpy @local112 {EXCELLENT})
			(= local11 global137)
		)
		(3000
			(StrCpy @local112 {VERY GOOD})
		)
		(2000
			(StrCpy @local112 {GOOD})
		)
		(1500
			(StrCpy @local112 {FAIR})
		)
		(1000
			(StrCpy @local112 {DANGER})
			(= local11 global135)
		)
		(500
			(StrCpy @local112 {CRITICAL})
			(= local11 global143)
		)
	)
	(if (and (< 0 temp0 3000) (not (mod temp0 250)))
		(proc704_6 (Format @local12 704 0 temp0 @local112)) ; "T minus %d - Safety margin: %s"
		(alertSound play:)
	)
	(if (and temp0 (!= gCurRoomNum 544) (!= (gCurRoom curPic:) 699))
		(if (not local10)
			(proc0_12 {Time to Format:} 67 0 180 70 100 28 local11)
		)
		(proc0_12 local10)
		(= local10
			(proc0_12 (Format @local12 704 1 temp0) 67 90 180 70 25 28 local11) ; "%d"
		)
	)
)

(procedure (proc704_6)
	(if (== gCurRoomNum gNewRoomNum)
		(voiceWindow color: global143 back: global129)
		(Print
			&rest
			#window
			voiceWindow
			#title
			{Metallic Voice:}
			#mode
			1
			#at
			160
			10
			#width
			150
			#time
			3
			#dispose
		)
	)
)

(procedure (localproc_2 param1)
	(return
		(cond
			((!= (param1 level:) (brain level:)) 0)
			((IsFlag 38) 0)
			((== (param1 lastRoom:) gCurRoomNum) 0)
			((== (param1 room:) (gCurRoom north:)) 1)
			((== (param1 room:) (gCurRoom south:)) 3)
			((== (param1 room:) (gCurRoom east:)) 2)
			((== (param1 room:) (gCurRoom west:)) 4)
			(else 0)
		)
	)
)

(procedure (localproc_3 param1)
	(cond
		((or (< (gEgo heading:) 45) (> (gEgo heading:) 305))
			(switch param1
				(1
					(return 0)
				)
				(3
					(return 1)
				)
				(2
					(return 2)
				)
				(4
					(return 3)
				)
			)
		)
		((< (gEgo heading:) 135)
			(switch param1
				(1
					(return 3)
				)
				(3
					(return 2)
				)
				(2
					(return 0)
				)
				(4
					(return 1)
				)
			)
		)
		((< (gEgo heading:) 235)
			(switch param1
				(1
					(return 1)
				)
				(3
					(return 0)
				)
				(2
					(return 3)
				)
				(4
					(return 2)
				)
			)
		)
		(else
			(switch param1
				(1
					(return 2)
				)
				(3
					(return 3)
				)
				(2
					(return 1)
				)
				(4
					(return 0)
				)
			)
		)
	)
)

(procedure (localproc_4 param1 &tmp [temp0 40])
	(Print
		(Format ; "You hear an electronic hum approaching from %s."
			@temp0
			704
			2
			(switch (localproc_3 param1)
				(0 {ahead of you})
				(1 {behind you})
				(3 {your left})
				(2 {your right})
			)
		)
		(gLongSong2 number: 845 vol: 0 loop: -1 play: fade: 127 1 10 0)
	)
)

(instance voiceWindow of SysWindow
	(properties)
)

(class brain of Rgn
	(properties
		level 1
		formatting 0
		lastRoom 0
		exitDir 0
	)

	(method (init &tmp temp0 temp1 temp2)
		(LoadMany rsVIEW 501 28 506)
		(super init: &rest)
		(if (and (not (IsFlag 38)) (!= gCurRoomNum 541))
			(droid1 init:)
			(droid2 init:)
		)
		(switch level
			(1
				(= temp0 2)
			)
			(2
				(= temp0 3)
			)
			(3
				(= temp0 -1)
			)
		)
		(if (== gCurRoomNum 541)
			(gEgo
				view: 0
				setCycle: StopWalk 4
				headView: 4
				illegalBits: 0
				setPri: temp0
				normal: 1
			)
		else
			(gEgo
				view: 3
				setCycle: StopWalk 510
				headView: 510
				illegalBits: 0
				setPri: temp0
				normal: 1
			)
		)
		(= local10 0)
		(cond
			((OneOf gCurRoomNum 541 544)
				(= temp2 0)
			)
			((brain formatting:)
				(= temp2 869)
			)
			((== gCurRoomNum 520)
				(= temp2 849)
			)
			((== gCurRoomNum 514)
				(= temp2 850)
			)
			(else
				(= temp2 20)
			)
		)
		(cond
			((not temp2)
				(gLongSong fade:)
			)
			((!= (gLongSong number:) temp2)
				(gLongSong number: temp2 vol: 127 loop: -1 play:)
			)
		)
		(if (= temp1 (localproc_2 droid1))
			(localproc_4 temp1)
		)
		(if (= temp1 (localproc_2 droid2))
			(localproc_4 temp1)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if (droid1 mover:)
			(droid1 setMotion: 0)
		)
		(if (droid2 mover:)
			(droid2 setMotion: 0)
		)
		(if
			(not
				(= keep
					(OneOf
						newRoomNumber
						150
						500
						505
						510
						514
						515
						520
						525
						541
						544
						545
					)
				)
			)
			(gLongSong fade:)
		)
		(= initialized 0)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gLongSong2 fade:)
	)

	(method (makePolygon &tmp temp0)
		(= temp0 (Polygon new:))
		(temp0 init: &rest type: 2)
		(gCurRoom addObstacle: temp0)
	)

	(method (doit)
		(super doit:)
		(if formatting
			(if (and local10 (== (gCurRoom curPic:) 699))
				(= local10 0)
			)
			(localproc_1)
			(if (not (-- formatting))
				(EgoDead 0 5)
			)
		)
		(cond
			((gCurRoom script:))
			((and (StepOn gEgo 8) (!= gCurRoomNum 150))
				(gCurRoom setScript: rgnExitScript 0 exitDir)
			)
		)
	)
)

(class SecurityDroid of Actor
	(properties
		description {security droid}
		lookStr {It's a security droid!}
		room 0
		lastRoom 0
		level 0
		path 0
		attacks 0
		body 0
	)

	(method (init)
		(= illegalBits 0)
		(= signal 26624)
		(self setCycle: Fwd)
		(if (IsObject path)
			(self setMotion: path)
		)
		(super init: &rest)
		(if body
			(body init:)
		)
		(= attacks 0)
		(self doit:)
		(if body
			(body doit:)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			(script)
			((not mover)
				(if (!= gCurRoomNum 545)
					(self setMotion: path)
				)
			)
			(else
				(switch level
					(1
						(self setPri: 2)
					)
					(2
						(self setPri: 3)
					)
					(else
						(self setPri: -1)
					)
				)
				(if
					(and
						(OneOf room gCurRoomNum (brain lastRoom:))
						(== level (brain level:))
					)
					(= temp0 (self distanceTo: gEgo))
					(cond
						((== attacks 3)
							(self attack: 1)
						)
						((< temp0 50)
							(self attack: 1)
						)
						((< temp0 100)
							(self attack: 0)
						)
					)
				)
			)
		)
	)

	(method (onMe)
		(return (or (super onMe: &rest) (body onMe: &rest)))
	)

	(method (attack param1)
		(cond
			((and (!= room (gCurRoom curPic:)) (!= gCurRoomNum 545)))
			((not (InRect 0 0 320 190 (gEgo x:) (gEgo y:))))
			((== gCurRoomNum 545)
				(cond
					((not mover))
					((mover isKindOf: RegionPath)
						(self setMotion: PolyPath (mover x:) (mover y:))
					)
				)
			)
			(else
				(++ attacks)
				(self setScript: shootEgo 0 param1)
			)
		)
	)
)

(instance droid1 of SecurityDroid
	(properties
		z 44
		view 506
		cycleSpeed 1
	)

	(method (init)
		(= path droidPath1)
		(= body droid1Body)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(switch room
			(525
				(if (and (self inRect: 0 0 64 40) (== level 3))
					(self setPri: 4)
				)
			)
			(515
				(if (and (< x 120) (== level 2))
					(self setPri: 5)
				)
			)
		)
	)
)

(instance droid2 of SecurityDroid
	(properties
		z 44
		view 506
		cycleSpeed 1
	)

	(method (init)
		(= path droidPath2)
		(= body droid2Body)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(switch room
			(525
				(if (and (self inRect: 0 0 64 40) (== level 3))
					(self setPri: 4)
				)
			)
			(515
				(if (and (< x 120) (== level 2))
					(self setPri: 5)
				)
			)
		)
	)
)

(instance droid1Body of Prop
	(properties
		view 506
		loop 1
	)

	(method (doit)
		(super doit:)
		(if (droid1 loop:)
		else
			(self
				x: (droid1 x:)
				y: (droid1 y:)
				z: (- (droid1 z:) 44)
				setPri: (droid1 priority:)
				signal: (| (droid1 signal:) $4000)
			)
		)
	)
)

(instance droid2Body of Prop
	(properties
		view 506
		loop 1
	)

	(method (doit)
		(super doit:)
		(if (droid2 loop:)
		else
			(self
				x: (droid2 x:)
				y: (droid2 y:)
				z: (- (droid2 z:) 44)
				setPri: (droid2 priority:)
				signal: (| (droid2 signal:) $4000)
			)
		)
	)
)

(instance droidPath1 of RegionPath
	(properties
		theRegion 704
	)

	(method (at param1)
		(client room: currentRoom level: (localproc_0 client))
		(return [local152 param1])
	)

	(method (next)
		(if (and (OneOf value 71 205) (!= gCurRoomNum 515))
			(+= value 2)
			(client posn: [local152 (++ value)] [local152 (++ value)])
		)
		(super next:)
	)

	(method (nextRoom &tmp temp0)
		(client lastRoom: (client room:))
		(super nextRoom: &rest)
		(if (== (client lastRoom:) gCurRoomNum)
			(gLongSong2 fade:)
		)
		(if (= temp0 (localproc_2 client))
			(localproc_4 temp0)
		)
	)
)

(instance droidPath2 of RegionPath
	(properties
		value 77
		theRegion 704
	)

	(method (at param1)
		(client room: currentRoom level: (localproc_0 client))
		(return [local152 param1])
	)

	(method (next)
		(if (and (OneOf value 71 205) (!= gCurRoomNum 515))
			(+= value 2)
			(client posn: [local152 (++ value)] [local152 (++ value)])
		)
		(super next:)
	)

	(method (nextRoom &tmp temp0)
		(client lastRoom: (client room:))
		(super nextRoom: &rest)
		(if (== (client lastRoom:) gCurRoomNum)
			(gLongSong2 fade:)
		)
		(if (= temp0 (localproc_2 client))
			(localproc_4 temp0)
		)
	)
)

(instance blast of Prop
	(properties)
)

(instance timerSound of Sound
	(properties
		number 879
	)
)

(instance laserSound of Sound
	(properties
		number 105
	)
)

(instance alertSound of Sound
	(properties
		number 101
	)
)

(instance shootEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laserSound play:)
				(client setMotion: 0)
				(if register
					(= local2 (gEgo x:))
					(= local3 (- (gEgo y:) 15))
				else
					(= local2 (+ (gEgo x:) (- (Random 1 20) 10)))
					(= local3 (+ (gEgo y:) (- (Random 1 20) 10)))
				)
				(= local0 (Min 320 (Max 0 (client x:))))
				(= local1 (Min 190 (Max 0 (- (client y:) 44))))
				(= local4 (- (Min local1 local3) 1))
				(= local6 (+ (Max local1 local3) 1))
				(= local5 (- (Min local0 local2) 1))
				(= local7 (+ (Max local0 local2) 1))
				(= local8 (Graph grSAVE_BOX local4 local5 local6 local7 1))
				(Graph grDRAW_LINE local1 local0 local3 local2 global143 -1 -1)
				(Graph grREDRAW_BOX local4 local5 local6 local7 1)
				(= cycles 1)
			)
			(1
				(Graph grRESTORE_BOX local8)
				(Graph grREDRAW_BOX local4 local5 local6 local7 1)
				(client setMotion: PolyPath (gEgo x:) (gEgo y:))
				(if register
					(gEgo
						view: 511
						setLoop: (if (< (client x:) (gEgo x:)) 0 else 1)
						setCel: 0
						setMotion: 0
						setCycle: End self
					)
				else
					(blast
						view: 28
						x: local2
						y: local3
						signal: 24576
						init:
						setCycle: End self
					)
				)
			)
			(2
				(if register
					(EgoDead 8 20)
				else
					(blast dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance terminal1 of Feature
	(properties
		description {terminal interface}
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(if (!= (brain level:) 1)
			(Print 704 3) ; "You can't reach it from this level."
		else
			(switch theVerb
				(1 ; Look
					(gCurRoom setScript: pocketPalScript self 0)
				)
				(3 ; Inventory
					(if (== invItem 15) ; laptop
						(gCurRoom setScript: pocketPalScript 0 self)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance terminal2 of Feature
	(properties
		description {terminal interface}
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(if (!= (brain level:) 2)
			(Print 704 3) ; "You can't reach it from this level."
		else
			(switch theVerb
				(1 ; Look
					(gCurRoom setScript: pocketPalScript self 0)
				)
				(3 ; Inventory
					(if (== invItem 15) ; laptop
						(gCurRoom setScript: pocketPalScript 0 self)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance terminal3 of Feature
	(properties
		description {terminal interface}
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(if (!= (brain level:) 3)
			(Print 704 3) ; "You can't reach it from this level."
		else
			(switch theVerb
				(1 ; Look
					(gCurRoom setScript: pocketPalScript self 0)
				)
				(3 ; Inventory
					(if (== invItem 15) ; laptop
						(gCurRoom setScript: pocketPalScript 0 self)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance pocketPalPanel of View
	(properties
		x 35
		y 46
		view 501
		priority 14
		signal 16
	)
)

(instance pocketPalPlug of Prop
	(properties
		x 36
		y 41
		description {terminal interface}
		lookStr {"Slot A (Insert terminal plug here)"}
		view 501
		loop 1
		priority 15
		signal 16
	)

	(method (dispose)
		(pocketPalPanel dispose:)
		(super dispose:)
	)

	(method (cue)
		(self dispose:)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo distanceTo: local9) 30)
			(self dispose:)
		)
	)
)

(instance pocketPalScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= local9 register)
				else
					(= local9 caller)
					(= caller 0)
				)
				(HandsOff)
				(if (> (gEgo distanceTo: local9) 30)
					(gEgo setMotion: PolyPath (local9 x:) (local9 y:) self)
				else
					(= cycles 1)
				)
			)
			(1
				(if register
					(cond
						((not (== ((gInventory at: 11) owner:) 1)) ; plug
							(Print 704 4) ; "The PocketPal(tm) doesn't plug in directly. Maybe you need some kind of adapter."
						)
						((not (== ((gInventory at: 4) owner:) 1)) ; battery
							(Print 704 5) ; "You turn the power on, but nothing happens."
						)
						((!= ((gInventory at: 11) state:) global170) ; plug
							(Print 704 6) ; "The adapter plug doesn't seem to fit into Slot A of the interface."
						)
						(else
							(brain lastRoom: gCurRoomNum)
							(gCurRoom newRoom: 545)
						)
					)
				else
					(pocketPalPanel init:)
					(pocketPalPlug cel: global170 init:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rgnExitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: register self)
			)
			(1
				(gEgo setMotion: MoveFwd 50 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

