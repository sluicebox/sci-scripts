;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Interface)
(use castle)
(use DLetter)
(use n762)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm063 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 42] = [0 189 0 0 319 0 319 142 255 136 255 131 227 126 124 126 124 127 205 127 214 135 117 142 101 142 101 147 74 149 67 154 37 159 29 165 36 171 54 173 136 189]
	[local49 12] = [182 189 278 185 312 153 300 143 319 143 319 189]
	[local61 9] = [1002 116 63 4 11 29 20 28 31]
)

(instance rm063 of KQ5Room
	(properties
		picture 63
		east 62
		south 64
	)

	(method (init)
		(super init:)
		(= global357 270)
		(= global358 156)
		(= global355 45)
		(= global356 160)
		(cond
			((== global331 5)
				(if (not (IsFlag 66))
					(wand init:)
					(= local1 1)
				)
				((ScriptID 550 7) init: setScript: wizSleepingScript) ; theWizard
			)
			((== global331 6)
				(proc550_17)
				(= global331 8)
				(= local2 1)
				(= global351 135)
				(= global354 315)
				((ScriptID 550 7) ; theWizard
					view: 706
					setLoop: 0
					posn: 155 142
					setPri: 8
					init:
					setScript: wakeUpScript
				)
			)
			((not global352)
				(if (> (Random 0 100) 90)
					(Load rsSOUND 835)
					(Load rsVIEW 703)
					(= local2 1)
					(= global351 135)
					(= global354 315)
					((ScriptID 550 7) ; theWizard
						init:
						view: 705
						setLoop: 8
						setScript: wizWaitingScript
					)
				else
					(if (> (Random 0 100) 20)
						(proc550_16)
					)
					(if (== global332 1)
						(= global359 0)
					else
						(= global359 121)
					)
				)
			)
		)
		(switch gPrevRoomNum
			(south
				(gCurRoom setScript: enterSouth)
			)
			(else
				(gCurRoom setScript: enterEast)
			)
		)
		(gEgo init:)
		(poly1 points: @local7 size: 21)
		(poly2 points: @local49 size: 6)
		(self
			setFeatures: windows statue table door bed robin interior
			setRegions: 550 ; castle
			addObstacle: poly1 poly2
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 288 138 320 150)
				(gCurRoom setScript: exitEast)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(switch temp0
					(64
						(gCurRoom setScript: exitSouth)
					)
				)
			)
			((gEgo inRect: 53 141 125 206)
				(= global351 135)
				(= global354 135)
				(switch global331
					(3
						(= global349 87)
						(= global350 157)
						((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
					)
					(6
						(= global331 7)
						((ScriptID 550 7) setScript: wakeUpScript) ; theWizard
					)
				)
			)
			((gEgo inRect: 206 145 260 171)
				(if (< (gEgo y:) 153)
					(= global354 225)
				else
					(= global354 315)
				)
				(switch global331
					(3
						(if (< (gEgo x:) 230)
							(= global351 225)
							(= global354 45)
						else
							(= global351 135)
							(= global354 315)
						)
						(= global349 230)
						(= global350 135)
						((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
					)
					(6
						(= global331 7)
						((ScriptID 550 7) setScript: wakeUpScript) ; theWizard
					)
				)
			)
		)
		(if (and global359 (not (IsFlag 64)) (!= local5 (GetTime 1))) ; SysTime12
			(= local5 (GetTime 1)) ; SysTime12
			(if (not (-- global359))
				(= global352 2)
			)
		)
		(if (< (gEgo y:) 133)
			(if (and (not local0) (or (== global331 3) (== global331 6)))
				(proc550_17)
				(= local0 1)
				(gEgo setMotion: PolyPath 267 151)
			)
			(gEgo setPri: 7)
		else
			(gEgo setPri: -1)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
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

(instance glow1 of Prop ; UNUSED
	(properties
		x 79
		y 189
		view 706
		loop 1
		priority 15
		signal 16
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 648)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance crystal of Prop ; UNUSED
	(properties
		x 222
		y 114
		view 706
		priority 15
		signal 16
	)
)

(instance table of RFeature
	(properties
		nsTop 126
		nsLeft 106
		nsBottom 139
		nsRight 131
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if local1
						(Say 649)
						(event claimed: 1)
					)
				)
				(3 ; Do
					(if local1
						(proc550_17)
						(gCurRoom setScript: getWand)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance statue of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 650)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bed of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (gCast contains: (ScriptID 550 7)) ; theWizard
						(Say 35)
					else
						(Say 651)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (gCast contains: (ScriptID 550 7)) ; theWizard
						(Say 655)
					else
						(Say 656)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door of RFeature
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
					(Say 652)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance interior of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 653)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance enterEast of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo view: 0 posn: 319 142 setMotion: PolyPath 267 151 self)
			)
			(1
				(proc550_18)
				(if local2
					(wizWaitingScript cue:)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance exitEast of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(if (or (== global331 3) (== global331 6))
					(self changeState: 100)
				else
					(gEgo setMotion: MoveTo 319 142 self)
				)
			)
			(1
				(gCurRoom newRoom: 62)
			)
			(100
				(gEgo setMotion: MoveTo 267 151 self)
			)
			(101
				(switch global331
					(3
						(= global351 135)
						(= global354 225)
						(= global349 230)
						(= global350 135)
						((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
					)
					(6
						(= global331 7)
						((ScriptID 550 7) setScript: wakeUpScript) ; theWizard
					)
				)
			)
		)
	)
)

(instance exitSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo setMotion: MoveTo 151 273 self)
			)
			(1
				(gCurRoom newRoom: 64)
			)
		)
	)
)

(instance wand of Prop
	(properties
		x 117
		y 128
		view 708
		loop 2
		priority 9
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (and (> (++ local4) 20) (not local3))
			(= local3 1)
			(= local4 0)
			(self setCycle: End)
		)
		(if (and (> local4 45) (== local3 1))
			(= local3 0)
			(= local4 0)
			(self setCycle: Beg)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 649)
					(event claimed: 1)
				)
				(3 ; Do
					(proc550_17)
					(gCurRoom setScript: getWand)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance getWand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: PolyPath 131 141 self
				)
			)
			(1
				(proc550_19)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 708
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(= cycles 5)
			)
			(3
				(= local1 0)
				(wand dispose:)
				(proc550_19)
				(gEgo loop: 1 cel: 0 setCycle: End self)
				(SetFlag 66)
				(gEgo get: 35) ; Mordack_s_Wand
				(SetScore 3)
			)
			(4
				((gEgo head:) show:)
				(gEgo normal: 1 view: 0)
				(proc550_18)
				(client setScript: 0)
			)
		)
	)
)

(instance wizSleepingScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				0
				((ScriptID 550 7) view: 706 setLoop: 0 posn: 155 142 setPri: 8) ; theWizard
				(= cycles 1)
			)
			(1
				1
				(= seconds (Random 5 20))
			)
			(2
				2
				((ScriptID 550 7) setCycle: End self) ; theWizard
			)
			(3
				3
				(= seconds (Random 5 20))
			)
			(4
				4
				((ScriptID 550 7) setCycle: Beg self) ; theWizard
				(= state 0)
			)
		)
	)
)

(instance wakeUpScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(Load rsSOUND 835)
				(Load rsVIEW 703)
				(proc550_17)
				((ScriptID 550 7) ; theWizard
					setLoop: 1
					cycleSpeed: 0
					cel: 0
					ignoreActors: 1
					illegalBits: 0
					setPri: -1
					setCycle: End self
				)
			)
			(1
				((ScriptID 550 7) setLoop: 2 cel: 0 setCycle: End self) ; theWizard
			)
			(2
				(self setScript: wizWaitingScript)
			)
		)
	)
)

(instance wizWaitingScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlobalSound stop:)
				(gGlobalSound3 number: 835 loop: 1 playBed:)
				(cond
					((== global331 7)
						(self cue:)
					)
					((!= global331 8)
						(switch gPrevRoomNum
							(64
								((ScriptID 550 7) posn: 101 163) ; theWizard
							)
							(else
								((ScriptID 550 7) posn: 196 130 setPri: 7) ; theWizard
							)
						)
					)
				)
			)
			(1
				(proc550_17)
				(gEgo setMotion: 0)
				(if (not global351)
					(if (< (gEgo x:) ((ScriptID 550 7) x:)) ; theWizard
						(= global351 225)
						(= global354 45)
					else
						(= global351 135)
						(= global354 315)
					)
				)
				(proc762_1 @local61 926)
				(switch global351
					(135
						(= temp0 8)
					)
					(225
						(= temp0 9)
					)
					(45
						(= temp0 10)
					)
					(315
						(= temp0 11)
					)
				)
				((ScriptID 550 7) ; theWizard
					view: 705
					setLoop: temp0
					cycleSpeed: 2
					cel: 0
					setCycle: CT 6 1 self
				)
			)
			(2
				((ScriptID 550 1) ; theAura
					init:
					setCycle: Fwd
					posn:
						(+ ((ScriptID 550 7) x:) 19) ; theWizard
						(- ((ScriptID 550 7) y:) 41) ; theWizard
				)
				(= seconds 2)
			)
			(3
				((gEgo head:) hide:)
				(switch global354
					(135
						(= temp0 0)
					)
					(225
						(= temp0 1)
					)
					(45
						(= temp0 6)
					)
					(315
						(= temp0 7)
					)
				)
				(proc550_19)
				(gEgo view: 132 normal: 0 setLoop: temp0 setCycle: End self)
			)
			(4
				(proc550_19)
				(gEgo setLoop: (+ (gEgo loop:) 2) setCycle: Fwd)
				(= seconds 6)
			)
			(5
				((ScriptID 550 1) hide:) ; theAura
				((ScriptID 550 7) setCel: 255) ; theWizard
				(switch global354
					(135
						(= temp0 4)
					)
					(225
						(= temp0 5)
					)
					(45
						(= temp0 10)
					)
					(315
						(= temp0 11)
					)
				)
				(proc550_19)
				(gEgo setLoop: temp0 cel: 0 setCycle: End self)
			)
			(6
				((ScriptID 550 7) cycleSpeed: 3 setCycle: Beg) ; theWizard
				(= seconds 4)
				(= global103 0)
			)
			(7
				(= global330 657)
				(EgoDead 73 0 -1)
			)
		)
	)
)

(instance windows of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 654)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance enterSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo view: 0 posn: 151 273 setMotion: PolyPath 151 183 self)
			)
			(1
				(if local2
					(wizWaitingScript cue:)
				else
					(proc550_18)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance robin of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 63 0) ; "Special thanks to Robin Bradley and the rest of the QA staff."
					(event claimed: 1)
				)
			)
		)
	)
)

