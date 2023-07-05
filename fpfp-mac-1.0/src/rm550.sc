;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use Window)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	rm550 0
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
	local12
	[local13 19] = [68 59 79 63 101 55 127 66 156 56 188 64 217 55 245 63 266 57 -32768]
)

(procedure (localproc_0 param1 param2 param3)
	(if (<= (GetDistance param2 param3 (param1 x:) (param1 y:)) local6)
		(return 1)
	else
		(return 0)
	)
)

(instance rm550 of FPRoom
	(properties
		picture 780
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(GunSound play:)
				(return 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) $0040) ; direction
			(return 0)
		else
			(super handleEvent: event)
		)
	)

	(method (init)
		(LoadMany rsSOUND 2552 2204 2800 2801 2802 2102 2751 560 2550 2549 548)
		(LoadMany rsVIEW 550)
		(super init:)
		(= local2 2)
		(= local1 40)
		(= local0 4)
		(sriniHiderR init:)
		(sriniHiderL init:)
		(gEgo get: -1 44) ; Pistols
		(self setScript: sStartRoom)
	)

	(method (dispose)
		(= gCurPuzzle 24)
		(DisposeScript 983)
		(super dispose:)
	)
)

(instance sStartRoom of Script
	(properties)

	(method (changeState newState &tmp [temp0 10] temp10)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gGame setCursor: 999 1)
				(switch
					(Print
						font: gUserFont
						window: SysWindow
						mode: 1
						addTitle: 14 0 2 1 550
						addButton: 1 15 0 0 1 0 0 550 ; "Pardner, I could outgun the  Magnificent Seven! Bring 'em on!"
						addButton: 2 15 0 0 2 0 30 550 ; "Well, I won at tiddly-winks the  other day. I'll give it m'best shot."
						addButton: 3 15 0 0 3 0 60 550 ; "Let's face it, I'm a wuss."
						init:
					)
					(0
						(= local12 1)
						(= cycles 2)
					)
					(1
						(= local12 0)
						(= cycles 2)
					)
					(2
						(= local12 2)
						(= cycles 2)
					)
					(3
						(= local12 1)
						(= cycles 2)
					)
				)
			)
			(2
				(gGame handsOn:)
				(proc0_9 220)
				(gTheIconBar
					curIcon: (gTheIconBar useIconItem:)
					curInvIcon: ((gInventory at: 44) cursor: 10 yourself:) ; Pistols
					enable: (gTheIconBar at: 5)
				)
				((gTheIconBar curIcon:) cursor: 10)
				(gGame setCursor: ((gTheIconBar at: 5) cursor:))
				(gTheIconBar select: (gTheIconBar at: 5))
				(gTheIconBar disable: 0 1 2 3 6)
				(gCurRoom drawPic: 550)
				(Format @temp0 {%d} local10)
				(Display {} dsRESTOREPIXELS local11)
				(= local11 (Display @temp0 dsCOORD 152 173 dsCOLOR 44 dsFONT global121 dsSAVEPIXELS))
				(switch local12
					(1
						(= local4 2)
						(= local3 1)
						(= local7 (+ 240 local1))
						(= local6 (+ 10 local0))
						(= local8 60)
						(= local9 1)
					)
					(2
						(= local4 4)
						(= local3 3)
						(= local6 (+ 7 local0))
						(= local7 (+ 150 local1))
						(= local8 30)
						(= local9 2)
					)
					(0
						(= local4 6)
						(= local3 5)
						(= local6 (+ 5 local0))
						(= local7 (+ 60 local1))
						(= local8 20)
						(= local9 3)
					)
				)
				(for ((= temp10 1)) (<= temp10 local4) ((++ temp10))
					((shootTarget new:) init:)
				)
				(gGameMusic1 number: 548 loop: -1 play:)
				(faller
					init:
					hide:
					setScale: Scaler 76 52 71 58
					setScript: sShowFallingGuy
				)
				(srini
					init:
					setLoop: 4
					setScale: Scaler 64 50 46 45
					setScript: sFlyingSrini
				)
				(corner1
					init:
					ignoreActors:
					ignoreHorizon:
					stopUpd:
					yStep: 30
					setLoop: 11
				)
				(corner2
					init:
					ignoreActors:
					ignoreHorizon:
					stopUpd:
					yStep: 30
					setLoop: 11
				)
				(corner3
					init:
					ignoreActors:
					ignoreHorizon:
					stopUpd:
					yStep: 30
					setLoop: 11
				)
				(corner4
					init:
					ignoreActors:
					ignoreHorizon:
					stopUpd:
					yStep: 30
					setLoop: 11
				)
				(lever1 init: 1)
				(lever2 init: 1)
				(lever3 init: 1)
				(lever4 init: 1)
				(tntShed init:)
				(rope init: stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sShowFallingGuy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 10))
			)
			(1
				(client cel: 0 show:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sHitFaller of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client hide:)
				(= next sShowFallingGuy)
				(self dispose:)
			)
		)
	)
)

(instance sFlyingSrini of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client stopUpd:)
				(= seconds (Random 2 10))
			)
			(1
				(client setMotion: sriniPath self)
			)
			(2
				(client posn: 23 49)
				(self changeState: 0)
			)
		)
	)
)

(instance sKillSrini of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(srini setMotion: 0 setCycle: End self)
			)
			(1
				(= global122 12)
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance sMoveShed of Script
	(properties)

	(method (dispose)
		(if (IsObject client)
			(client myTravelScript: 0)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setMotion: MoveTo (Random 104 205) (client y:) self
					shootable: 1
				)
			)
			(1
				(client
					myRow: 5
					setMotion:
						MoveTo
						(if (client dirToGo:) -20 else 340)
						(client y:)
						self
				)
			)
			(2
				(client shootable: 0)
				(client timeToMove: 1)
			)
		)
	)
)

(instance sGotShed of Script
	(properties)

	(method (dispose)
		(if (IsObject client)
			(client myDeathScript: 0 init: 1)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
				(GunSound play: 2751)
			)
			(1
				(client setMotion: 0)
				(= ticks 60)
			)
			(2
				(client cel: 0 posn: 0 0 timeToMove: 1)
				(self dispose:)
			)
		)
	)
)

(instance sMoveTarget of Script
	(properties)

	(method (dispose)
		(if (IsObject client)
			(client myTravelScript: 0)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop: (Random 5 9)
					setMotion: MoveTo (Random 104 205) (client y:) self
				)
				(switch (client loop:)
					(5
						(client
							name: {Vulture}
							worthPoints: 10
							deathSound: 2552
						)
					)
					(6
						(client name: {Sheep} worthPoints: -10 deathSound: 2800)
					)
					(7
						(client name: {Snail} worthPoints: 1 deathSound: 2204)
					)
					(8
						(client
							name: {Old Man}
							worthPoints: -25
							deathSound: 2801
						)
					)
					(9
						(client
							name: {Old Lady}
							worthPoints: -50
							deathSound: 2802
						)
					)
				)
			)
			(1
				(client
					myRow: 5
					setCycle: CT 2 1 self
					setMotion:
						MoveTo
						(if (client dirToGo:) -20 else 340)
						(client y:)
						self
				)
			)
			(2
				(client shootable: 1)
				(= ticks local7)
			)
			(3
				(client shootable: 0 setCycle: CT 0 -1 self)
			)
			(4 0)
			(5
				(= seconds 3)
			)
			(6
				(client timeToMove: 1)
			)
		)
	)
)

(instance sGotTarget of Script
	(properties)

	(method (dispose param1)
		(if (and argc param1 (IsObject client))
			(client myDeathScript: 0 script: 0 dispose:)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp [temp0 10])
		(switch (= state newState)
			(0
				(client shootable: 0)
				(+= local10 (client worthPoints:))
				(= cycles 2)
			)
			(1
				(Format @temp0 {%d} local10)
				(Display {} dsRESTOREPIXELS local11)
				(= local11 (Display @temp0 dsCOORD 152 173 dsCOLOR 44 dsFONT global121 dsSAVEPIXELS))
				(client setCycle: End self)
			)
			(2
				(client setMotion: 0)
				(= ticks 60)
			)
			(3
				(if (< local10 0)
					(= global122 6)
					(gCurRoom newRoom: 99) ; deathRoom
				else
					((shootTarget new:) init:)
					(self dispose: 1)
				)
			)
		)
	)
)

(instance sMoveLever of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client setMotion: MoveTo (Random 104 205) (client y:) self)
			)
			(1
				(client
					myRow: 5
					setCycle: CT 2 1 self
					setMotion:
						MoveTo
						(if (client dirToGo:) -20 else 340)
						(client y:)
						self
				)
				(flipSound number: 2549 play:)
			)
			(2
				(client shootable: 1)
				(= ticks local7)
			)
			(3
				(client shootable: 0)
				(flash
					posn: (client x:) (client y:)
					cel: 0
					setPri: 13
					init:
					setScale: -1 lever1
					show:
				)
				(= cycles 1)
			)
			(4
				(= temp0 (Random 0 2))
				(flash dispose:)
				(if (== temp0 2)
					(breakSound play:)
					((bulletHole new:)
						posn: (Random 10 310) (Random 10 180)
						cel: (Random 0 3)
						setPri: 15
						ignoreActors:
						addToPic:
					)
				)
				(client setCycle: CT 0 -1 self)
				(-- local8)
				(if (OneOf local8 0 5 10 15 20 25 30 35 40 45 50 55 60)
					(rope cel: (+ (rope cel:) local9) stopUpd:)
				)
				(if (== (rope cel:) 12)
					(= global122 6)
					(gCurRoom newRoom: 99) ; deathRoom
				)
			)
			(5 0)
			(6
				(client timeToMove: 1)
			)
		)
	)
)

(instance sGotLever of Script
	(properties)

	(method (dispose param1)
		(if (and argc param1 (IsObject client))
			(if (not (client hitPoints:))
				(client myDeathScript: 0 script: 0 dispose:)
			else
				(client init: 0)
			)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp [temp0 10])
		(switch (= state newState)
			(0
				(client shootable: 0)
				(+= local10 (client worthPoints:))
				(= cycles 2)
			)
			(1
				(Format @temp0 {%d} local10)
				(Display {} dsRESTOREPIXELS local11)
				(= local11 (Display @temp0 dsCOORD 152 173 dsCOLOR 44 dsFONT global121 dsSAVEPIXELS))
				(client setCycle: End self)
			)
			(2
				(client setMotion: 0 hitPoints: (- (client hitPoints:) 1))
				(= ticks 60)
			)
			(3
				(cond
					((client hitPoints:)
						(client posn: 0 0 timeToMove: 1 myDeathScript: 0)
						(self dispose: 1)
					)
					((== (++ local5) 4)
						(gGameMusic1 number: 560 loop: 1 play:)
						(gGame handsOff: points: 20)
						(gCurRoom newRoom: 220)
					)
					(else
						(self dispose: 1)
					)
				)
			)
		)
	)
)

(instance sShootCorner of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: MoveTo (client x:) (+ (client y:) 200) self)
			)
			(1
				(client dispose:)
			)
		)
	)
)

(class Target of Actor
	(properties
		shootable 0
		worthPoints 0
		myRow 5
		dirToGo 0
		timeToMove 1
		myTravelScript 0
		myDeathScript 0
		deathSound 0
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if timeToMove
			(= temp0 (Random 0 3))
			(if
				(not
					(= temp1 (gCast firstTrue: #perform whosInThisRow temp0))
				)
				(= timeToMove 0)
				(= myRow temp0)
				(switch myRow
					(0
						(= x -20)
						(= y 101)
						(self setSpeed: (+ 1 local2))
						(= dirToGo 0)
						(self setPri: -1)
						(self setScale: Scaler 66 55 105 104)
					)
					(1
						(= x 340)
						(= y 110)
						(self setSpeed: (+ 2 local2))
						(self setPri: 8)
						(= dirToGo 1)
						(self setScale: Scaler 87 69 114 112)
					)
					(2
						(= x 340)
						(= y 123)
						(self setSpeed: (+ 3 local2))
						(self setPri: 10)
						(= dirToGo 1)
						(self setScale: Scaler 90 77 127 121)
					)
					(3
						(= x -20)
						(= y 140)
						(self setSpeed: (+ 4 local2))
						(self setPri: 11)
						(self setScale: 0)
						(= dirToGo 0)
					)
				)
				(if (== script myTravelScript)
					(script changeState: 0)
				else
					(self setScript: myTravelScript)
				)
			)
		)
	)

	(method (dispose)
		(if (and (IsObject myDeathScript) (myDeathScript isKindOf: Script))
			(myDeathScript dispose:)
			(= myDeathScript 0)
		)
		(if (and (IsObject myTravelScript) (myTravelScript isKindOf: Script))
			(myTravelScript dispose:)
			(= myTravelScript 0)
		)
		(super dispose:)
	)

	(method (init)
		(self ignoreActors:)
		(super init:)
	)

	(method (handleEvent event)
		(if (and shootable (localproc_0 self gMouseX gMouseY))
			(GunSound play: deathSound)
			(event claimed: 1)
			(self setScript: myDeathScript)
		)
	)
)

(class LeverBrother of Target
	(properties
		hitPoints 0
	)

	(method (init param1)
		(if param1
			(= hitPoints local3)
		)
		(= cel 0)
		(= myTravelScript (sMoveLever new:))
		(= myDeathScript (sGotLever new:))
		(= deathSound 2801)
		(super init:)
	)
)

(instance srini of Actor
	(properties
		x 23
		y 49
		view 550
		cel 2
		signal 4096
	)

	(method (handleEvent event)
		(GunSound play:)
		(event claimed: 1)
		(self setScript: sKillSrini)
	)
)

(instance corner1 of Actor
	(properties
		x 23
		y 71
		view 550
		priority 14
		signal 16
	)

	(method (handleEvent event)
		(GunSound play:)
		(event claimed: 1)
		(self setScript: (sShootCorner new:))
	)
)

(instance corner2 of Actor
	(properties
		x 297
		y 72
		view 550
		cel 1
		priority 14
		signal 16
	)

	(method (handleEvent event)
		(GunSound play:)
		(event claimed: 1)
		(self setScript: (sShootCorner new:))
	)
)

(instance corner3 of Actor
	(properties
		x 298
		y 132
		view 550
		cel 2
		priority 14
		signal 16
	)

	(method (handleEvent event)
		(GunSound play:)
		(event claimed: 1)
		(self setScript: (sShootCorner new:))
	)
)

(instance corner4 of Actor
	(properties
		x 22
		y 134
		view 550
		cel 3
		priority 14
		signal 16
	)

	(method (handleEvent event)
		(GunSound play:)
		(event claimed: 1)
		(self setScript: (sShootCorner new:))
	)
)

(instance faller of Prop
	(properties
		x 250
		y 78
		view 550
		loop 12
		priority 8
		signal 16
	)

	(method (handleEvent event)
		(GunSound play: 2102)
		(event claimed: 1)
		(if (!= script sHitFaller)
			(self setScript: sHitFaller)
		)
	)
)

(instance flash of Prop
	(properties
		view 550
		loop 14
	)

	(method (handleEvent event)
		(gCurRoom handleEvent: event)
	)
)

(instance rope of Prop
	(properties
		x 111
		y 159
		view 550
		loop 13
		priority 14
		signal 16
	)
)

(instance shootTarget of Target
	(properties
		view 550
	)

	(method (init &tmp temp0)
		(= myTravelScript (sMoveTarget new:))
		(= myDeathScript (sGotTarget new:))
		(super init:)
	)
)

(instance tntShed of Target
	(properties
		view 550
	)

	(method (init param1)
		(if (or (not argc) (not param1))
			(super init:)
		)
		(self setLoop: 10)
		(= myTravelScript sMoveShed)
		(= myDeathScript sGotShed)
	)

	(method (handleEvent event)
		(if (and shootable (localproc_0 self gMouseX gMouseY))
			(self shootable: 0)
			(event claimed: 1)
			(gCast eachElementDo: #perform killEmAll)
			(self setScript: myDeathScript)
		)
	)
)

(instance lever1 of LeverBrother
	(properties
		view 550
	)

	(method (init)
		(self setLoop: 0)
		(= worthPoints 75)
		(super init: &rest)
	)
)

(instance lever2 of LeverBrother
	(properties
		view 550
	)

	(method (init)
		(self setLoop: 1)
		(= worthPoints 100)
		(super init: &rest)
	)
)

(instance lever3 of LeverBrother
	(properties
		view 550
	)

	(method (init)
		(self setLoop: 2)
		(= worthPoints 125)
		(super init: &rest)
	)
)

(instance lever4 of LeverBrother
	(properties
		view 550
	)

	(method (init)
		(self setLoop: 3)
		(= worthPoints 150)
		(super init: &rest)
	)
)

(instance bulletHole of View
	(properties
		view 550
		loop 15
	)

	(method (handleEvent event)
		(gCurRoom handleEvent: event)
	)
)

(instance sriniHiderR of Feature
	(properties
		x 300
		y 70
	)

	(method (init)
		(super init:)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 247 0 319 0 319 79 226 79 226 61 222 47 247 22
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(event claimed: 1)
		(gCurRoom doVerb: 47)
	)
)

(instance sriniHiderL of Feature
	(properties
		x 30
		y 70
	)

	(method (init)
		(super init:)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 70 0 0 113 0 113 36 79 36 84 70
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(event claimed: 1)
		(gCurRoom doVerb: 47)
	)
)

(instance whosInThisRow of Code
	(properties)

	(method (doit param1 param2)
		(if (param1 respondsTo: #myRow)
			(return (== (param1 myRow:) param2))
		else
			(return 0)
		)
	)
)

(instance killEmAll of Code
	(properties)

	(method (doit param1)
		(if
			(and
				(param1 respondsTo: #worthPoints)
				(param1 worthPoints:)
				(param1 shootable:)
				(!= (param1 script:) (param1 myDeathScript:))
			)
			(param1 setScript: (param1 myDeathScript:))
		)
	)
)

(instance hitTargetSound of FPSound ; UNUSED
	(properties
		flags 1
		number 2552
	)
)

(instance shedSound of FPSound ; UNUSED
	(properties
		flags 1
		number 2751
	)
)

(instance flipSound of FPSound
	(properties
		flags 1
	)
)

(instance breakSound of FPSound
	(properties
		flags 1
		number 2542
	)
)

(class GunSound of FPSound
	(properties
		flags 1
		next 0
	)

	(method (play param1)
		(if (not next)
			(= number 2101)
		)
		(if argc
			(= next param1)
			(super play: self)
		else
			(super play:)
			(= next 0)
		)
	)

	(method (cue)
		(= number next)
		(self play:)
	)
)

(instance sriniPath of Path
	(properties)

	(method (at param1)
		(return [local13 param1])
	)
)

