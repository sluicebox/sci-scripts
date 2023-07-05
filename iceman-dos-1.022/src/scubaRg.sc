;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use Interface)
(use RegionPath)
(use n821)
(use SmoothLooper)
(use Wander)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scubaRg 0
	proc305_1 1
	proc305_2 2
)

(local
	[local0 13] = [32767 57 249 110 340 110 32767 56 -20 133 150 150 -32768]
	[local13 27] = [32767 56 150 150 340 167 32767 55 -20 150 160 150 340 134 32767 53 -20 134 340 134 32767 54 -20 134 208 148 -32768]
	[local40 19] = [32767 54 208 148 340 155 32767 61 -20 157 340 140 32767 58 -20 140 31 140 -32768]
	[local59 47] = [32767 58 31 140 -20 105 32767 61 340 97 167 110 -20 118 32767 54 340 120 -20 88 32767 53 340 83 -20 81 32767 55 340 105 158 108 -20 125 32767 56 340 129 -20 131 32767 57 340 107 273 107 -32768]
	local106
	local107
	local108
)

(procedure (proc305_1 param1 param2 param3 param4 param5 &tmp temp0)
	((= temp0 (PV new:)) view: 56 loop: param1 cel: param2 x: param3 y: param4)
	(if (> argc 4)
		(temp0 priority: param5)
	)
	(gAddToPics add: temp0)
)

(procedure (proc305_2 param1 param2 param3 param4)
	((Clone wavingPlant) loop: param1 x: param2 y: param3 setPri: param4 init:)
)

(instance scubaRg of Rgn
	(properties)

	(method (init)
		(Load rsSOUND 58)
		(Load rsSOUND 258)
		(fish1 init:)
		(fish2 init:)
		(schoolOfFish init:)
		(super init:)
		(bubbles init:)
		(if (not local106)
			(= local106 1)
			(gIceGlobalSound number: 60 priority: 1 loop: -1 play: egosBubbleScript)
		)
		(gEgo cycleSpeed: 2 setLoop: -1 setLoop: scubaLooper)
		(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			(= local107 1)
			(gEgo view: 54)
			(scubaLooper vNormal: 54 vChangeDir: 55)
		else
			(= local107 5)
			(gEgo view: 154)
			(scubaLooper vNormal: 154 vChangeDir: 254)
		)
		(torpedoRay init: setScript: rayScript setCycle: Walk)
		(air init: ignoreActors: 1 setPri: 15)
		(if (<= (/ global102 800) 0)
			(air hide:)
		)
		(gauge init: ignoreActors: 1 setPri: 15 addToPic:)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (and (== (scubaLooper vNormal:) 54) (not (gEgo has: 6))) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			(scubaLooper vNormal: 154 vChangeDir: 254)
		)
		(if (< 0 global102)
			(-= global102 local107)
			(if (< 0 (/ global102 800))
				(air setCel: (- 10 (/ global102 800)))
			else
				(air hide:)
			)
		else
			(EgoDead 157 0 1 305 0) ; "You ran out of air and were forced to surface. You were immediately spotted and captured."
		)
		(switch local108
			(1
				(EgoDead 157 0 1 305 1) ; "When you entered the harbor you were immediately spotted and captured. You should have created some kind of diversion."
			)
			(2
				(EgoDead 157 0 0 305 2) ; "By not hiding your dive vehicle under water before surfacing, it was found and you were captured."
			)
			(3
				(EgoDead 157 0 1 305 3) ; "When you surfaced, you were immediately spotted and captured. You should have waited until the coast was clear."
			)
			(4
				(EgoDead 157 0 1 305 3) ; "When you surfaced, you were immediately spotted and captured. You should have waited until the coast was clear."
			)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 53 54 55 56 57 58 61 45 46 47)) ; antiSubNetRm, shoreRm, shore2Rm, caveEntranceRm, westDeadEndRm, eastDeadEndRm, tunisBeachRm, netBeachRm, netToPierRm, tunaPierRm
		(= initialized 0)
		(if (!= ((gInventory at: 3) owner:) 51) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
			(= gCurRoomNum newRoomNumber)
			(= local108 1)
		)
		(if (OneOf newRoomNumber 999 70 71 72) ; fishermanBeachRm, tunaBeachRm1, tunaBeachRm2
			(cond
				((gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(= gCurRoomNum newRoomNumber)
					(= local108 2)
				)
				((== newRoomNumber 999)
					(= gCurRoomNum newRoomNumber)
					(= local108 3)
				)
				((not ((gInventory at: 4) ownedBy: 55)) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
					(= gCurRoomNum newRoomNumber)
					(= local108 3)
				)
				(else
					(gIceGlobalSound fade:)
					(gGame changeScore: 2)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'surface')
				(cond
					((gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
						(Print 305 4) ; "You must hide your diver vehicle first."
					)
					(((gInventory at: 4) ownedBy: 55) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
						(Print 305 5) ; "Go ahead."
					)
					(else
						(Print 305 6) ; "You don't know that it's safe to go to the surface."
					)
				)
			)
			((Said 'examine,look[<at]/gear,scuba,coat,wetsuit,equipment')
				(Print 305 7) ; "Typical scuba gear."
			)
			((Said 'look>')
				(cond
					((Said '[<at,around][/room]')
						(switch (Random 0 3)
							(0
								(Print 305 8) ; "You see nothing of significance."
							)
							(1
								(Print 305 9) ; "Searching, you find nothing."
							)
							(2
								(Print 305 10) ; "You look, but nothing here will help you."
							)
							(3
								(Print 305 11) ; "Looks like normal seascape for the area."
							)
						)
					)
					((Said '/cave')
						(Print 305 12) ; "You search for a cave but find none."
					)
					((Said '/rock')
						(switch (Random 0 1)
							(0
								(Print 305 13) ; "You look but see only a couple of star fish."
							)
							(1
								(Print 305 14) ; "You look behind the rock and see nothing."
							)
						)
					)
					(else
						(Print 305 15) ; "You look but find nothing that will help you."
						(event claimed: 1)
					)
				)
			)
			((Said 'get')
				(Print 305 16) ; "You don't need it."
			)
			((Said 'move>')
				(if (Said '/rock')
					(Print 305 17) ; "Moving the rock would be useless."
				else
					(Print 305 18) ; "You're wasting your time trying to move it."
				)
			)
		)
	)
)

(instance egosBubbleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(bubbles
					x:
						(switch (gEgo loop:)
							(0
								(+ (gEgo x:) 8)
							)
							(1
								(- (gEgo x:) 8)
							)
							(else
								(gEgo x:)
							)
						)
					y: (- (gEgo y:) 5)
					show:
					setPri: (gEgo priority:)
					setMotion: MoveTo (gEgo x:) 5 self
				)
			)
			(2
				(bubbles hide:)
				(= cycles 2)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance bubbles of Act
	(properties
		yStep 3
		view 54
		loop 4
	)

	(method (init)
		(self
			setCycle: Walk
			setLoop: 4
			ignoreActors:
			illegalBits: 0
			setScript: egosBubbleScript
		)
		(super init:)
		(self hide:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/bubbles]')
				(Print 305 19) ; "You see the air bubbles from your regulator."
			)
		)
	)
)

(instance wavingPlant of Prop
	(properties
		view 56
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd)
	)
)

(instance fish1 of Act
	(properties
		view 57
	)

	(method (init)
		(super init:)
		(self
			xStep: 1
			yStep: 1
			posn: (Random 20 300) (Random 100 150)
			cycleSpeed: 2
			setCycle: Walk
			setMotion: Wander 100
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/fish]')
				(Print 305 20) ; "This is a small fish."
			)
			((Said 'catch/fish')
				(Print 305 21) ; "You don't need the fish."
			)
			((Said 'kill/fish')
				(Print 305 22) ; "You have no time for idle pleasures."
			)
		)
	)

	(method (canBeHere)
		(if (super canBeHere:)
			(self inRect: -20 -20 340 210)
		)
	)
)

(instance fish2 of Act
	(properties
		view 67
	)

	(method (init)
		(super init:)
		(self
			xStep: 1
			yStep: 1
			cycleSpeed: 2
			setCycle: Walk
			posn: (Random 20 300) (Random 70 150)
			setMotion: Wander 100
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/fish]')
				(Print 305 20) ; "This is a small fish."
			)
			((Said 'catch/fish')
				(Print 305 21) ; "You don't need the fish."
			)
			((Said 'kill/fish')
				(Print 305 22) ; "You have no time for idle pleasures."
			)
		)
	)

	(method (canBeHere)
		(if (super canBeHere:)
			(self inRect: -20 -20 340 210)
		)
	)
)

(instance scubaLooper of SmoothLooper
	(properties
		vNormal 54
		vChangeDir 55
	)
)

(instance schoolOfFish of Act
	(properties
		view 267
	)

	(method (init)
		(super init:)
		(self
			posn: (Random 0 320) (Random 0 200)
			setMotion: Wander 100
			setCycle: Fwd
		)
	)

	(method (canBeHere)
		(if (super canBeHere:)
			(self inRect: -20 -20 340 210)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/fish]')
				(Print 305 23) ; "You see a school of small fish."
			)
			((Said 'catch/fish')
				(Print 305 24) ; "There are too many in this school."
			)
			((Said 'kill/fish')
				(Print 305 22) ; "You have no time for idle pleasures."
			)
		)
	)
)

(instance torpedoRay of Act
	(properties
		y 110
		x 259
		view 60
	)

	(method (init)
		(super init: &rest)
		(self ignoreControl: -32768 ignoreActors: 1)
	)

	(method (dispose)
		(= script 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/ray]')
				(Print 305 25) ; "You see what appears to be a ray of some kind."
			)
			((Said 'catch/ray')
				(proc0_34) ; "You're not close enough."
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				mover
				(== (mover currentRoom:) gCurRoomNum)
				(< (gEgo distanceTo: self) 20)
			)
			(gEgo setMotion: MoveTo (gEgo x:) (gEgo y:))
			(HandsOff)
			(script register: 0)
			(self setMotion: 0 setScript: electricuteScript)
		)
	)
)

(instance rayPath1 of RegionPath
	(properties
		endType 0
		theRegion 305
	)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance rayPath2 of RegionPath
	(properties
		endType 0
		theRegion 305
	)

	(method (at param1)
		(return [local13 param1])
	)
)

(instance rayPath3 of RegionPath
	(properties
		endType 0
		theRegion 305
	)

	(method (at param1)
		(return [local40 param1])
	)
)

(instance rayPath4 of RegionPath
	(properties
		endType 0
		theRegion 305
	)

	(method (at param1)
		(return [local59 param1])
	)
)

(instance rayScript of Script
	(properties)

	(method (init)
		(if register
			(client script: self setMotion: register)
		else
			(super init: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 3 setCycle: Walk setMotion: rayPath1 self)
				(= register rayPath1)
			)
			(1
				(= register 0)
				(client setCel: 0 setLoop: 5 setCycle: End self)
			)
			(2
				(client setLoop: 4 setCycle: End self)
			)
			(3
				(client setLoop: 3 setCycle: Walk setMotion: rayPath2 self)
				(= register rayPath2)
			)
			(4
				(= register 0)
				(client setLoop: 1 setCel: 16 cycleSpeed: 2 setCycle: Beg self)
			)
			(5
				(client stopUpd:)
				(= seconds 10)
			)
			(6
				(client setLoop: 1 setCycle: End self)
			)
			(7
				(client
					setLoop: 3
					cycleSpeed: 0
					setCycle: Walk
					setMotion: rayPath3 self
				)
				(= register rayPath3)
			)
			(8
				(= register 0)
				(client setLoop: 1 cycleSpeed: 2 setCycle: Beg self)
			)
			(9
				(client stopUpd:)
				(= seconds 10)
			)
			(10
				(client setLoop: 1 setCycle: End self)
			)
			(11
				(client setLoop: 5 cycleSpeed: 1 setCel: 0 setCycle: End self)
			)
			(12
				(client setLoop: 2 setCycle: Walk setMotion: rayPath4 self)
				(= register rayPath4)
			)
			(13
				(client setLoop: 0 setCycle: Beg self)
				(= register 0)
			)
			(14
				(= seconds 10)
			)
			(15
				(client setLoop: 0 setCycle: End self)
			)
			(16
				(client setLoop: 4 setCel: 0 setCycle: End self)
			)
			(17
				(self init:)
			)
		)
	)
)

(instance electricGlow of Prop
	(properties
		view 159
	)

	(method (init param1 param2 param3)
		(super init:)
		(self
			posn: param1 param2
			setPri: param3
			ignoreActors: 1
			setCycle: End self
		)
	)

	(method (cue)
		(self setLoop: 1 setCycle: Fwd)
	)
)

(instance electricuteScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(zap number: (proc0_5 58) play:)
				((Clone electricGlow)
					init:
						(torpedoRay x:)
						(torpedoRay y:)
						(+ (torpedoRay priority:) 2)
				)
				(= cycles 15)
			)
			(1
				((Clone electricGlow)
					init: (gEgo x:) (gEgo y:) (+ (gEgo priority:) 2)
				)
				(= cycles 50)
			)
			(2
				(EgoDead 951 2 0 305 26) ; "What a shocking experience!"
			)
		)
	)
)

(instance gauge of Prop
	(properties
		y 11
		x 22
		z 1
		view 54
		loop 5
		priority 15
	)
)

(instance air of Prop
	(properties
		y 8
		x 5
		z 2
		view 54
		loop 6
		cel 9
	)
)

(instance zap of Sound
	(properties
		priority 2
	)
)

