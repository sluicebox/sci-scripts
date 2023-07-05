;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30091)
(include sci.sh)
(use Main)
(use nExit)
(use Str)
(use BorderWindow)
(use PolyEdit)
(use WriteFeature)
(use TextField)
(use Sound)
(use Menu)
(use System)

(public
	trek 0
)

(local
	local0 = 38
	local1 = 50
	local2 = 520
	local3 = 280
	local4
	local5 = 5
	local6
	local7 = 3
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	[local16 5]
	local21
	local22
	local23
)

(instance trek of CloseupRoom
	(properties
		picture 3000
	)

	(method (init &tmp temp0)
		(for ((= temp0 101)) (<= temp0 105) ((++ temp0))
			(Load 140 temp0) ; WAVE
			((= [local16 (- temp0 101)] (bSound new:)) number: temp0 init:)
		)
		(= local12 (gThePlane left:))
		(= local13 (gThePlane top:))
		(= local14 (gThePlane right:))
		(= local15 (gThePlane bottom:))
		(= local6 0)
		(= local7 3)
		(= local4 0)
		(gPlanes plane: gThePlane)
		(= exitRoom gPrevRoomNum)
		(super init: &rest)
		(trekS init:)
		(= local8 (trekSet new:))
		(= local9 (trekSet new:))
		(gCast add: shaker)
		(gGame handsOn:)
	)

	(method (dispose &tmp temp0)
		(for ((= temp0 101)) (<= temp0 105) ((++ temp0))
			([local16 (- temp0 101)] stop: dispose:)
			(UnLoad 140 temp0)
		)
		(gPlanes plane: 0)
		(local8 dispose:)
		(local9 dispose:)
		(trekS dispose:)
		(gCast delete: shaker)
		(gThePlane setRect: local12 local13 local14 local15 update:)
		(if local10
			(local10 dispose:)
		)
		(super dispose: &rest)
	)
)

(instance trekSet of Set
	(properties)

	(method (add)
		(if (>= size 25)
			((self at: 0) dispose:)
		)
		(super add: &rest)
	)
)

(instance trekS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 0)
				(= seconds 1)
			)
			(1
				(= local10 (player new:))
				(eText new:)
				(scrText new:)
				(= seconds 3)
			)
			(2
				(if (< local4 local5)
					(enemy new:)
				)
				(= seconds (Random 3 8))
				(if (not local6)
					(-- state)
				)
			)
			(3
				(local8 dispose:)
				(= local8 (trekSet new:))
				(local9 dispose:)
				(= local9 (trekSet new:))
				(if (> local7 0)
					(= state -1)
					(= cycles 1)
				else
					(gCurRoom newRoom: (gCurRoom exitRoom:))
				)
			)
		)
	)
)

(class Wessel of View
	(properties
		dX 0
		dY 0
		dT 0
		lstTiks 0
		numTiks 0
		spd 4
		nrg 100
		pendP 0
		pCtr 5
		killMe 0
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init)
		(|= signal $1000)
		(super init: gThePlane)
	)

	(method (doit &tmp [temp0 3])
		(if (> nrg 0)
			(cond
				((not numTiks)
					(= numTiks spd)
					(if pCtr
						(-- pCtr)
					else
						(= pCtr 5)
						(if pendP
							(pendP new: self)
							(= pendP 0)
						)
					)
					(self move:)
				)
				((!= lstTiks (GetTime))
					(= lstTiks (GetTime))
					(-- numTiks)
				)
			)
			(if (and (== loop 5) (== cel 7))
				(= killMe 1)
			)
		else
			(self kaBoom:)
			(= nrg 10000)
		)
		(super doit:)
		(if killMe
			(self dispose:)
		)
	)

	(method (move &tmp temp0 temp1 temp2)
		(= temp0 cel)
		(= temp1 x)
		(= temp2 y)
		(+= temp1 dX)
		(+= temp2 dY)
		(+= temp0 dT)
		(if (> temp1 local2)
			(= temp1 local2)
			(= dX (- 0 dX))
		)
		(if (< temp1 local0)
			(= temp1 local0)
			(= dX (- 0 dX))
		)
		(if (> temp2 local3)
			(= temp2 local3)
			(= dY (- 0 dY))
		)
		(if (< temp2 local1)
			(= temp2 local1)
			(= dY (- 0 dY))
		)
		(if (> temp0 7)
			(= temp0 0)
		)
		(if (< temp0 0)
			(= temp0 7)
		)
		(self posn: temp1 temp2 setCel: temp0)
	)

	(method (setRect)
		(SetNowSeen self)
	)

	(method (contains param1)
		(if (or (== loop 5) (== name (param1 name:)))
			(return 0)
		else
			(return
				(cond
					(
						(or
							(> left (param1 right:))
							(< right (param1 left:))
							(> top (param1 bottom:))
							(< bottom (param1 top:))
						)
						0
					)
					(
						(and
							(<= left (param1 left:))
							(>= right (param1 right:))
							(<= top (param1 top:))
							(>= bottom (param1 bottom:))
						)
						2
					)
					(
						(and
							(>= left (param1 left:))
							(<= right (param1 right:))
							(>= top (param1 top:))
							(<= bottom (param1 bottom:))
						)
						3
					)
					(else 1)
				)
			)
		)
	)

	(method (kaBoom)
		(= dX (= dY 0))
		(= dT 1)
		(self setCel: 0 setLoop: 5)
	)
)

(instance player of Wessel
	(properties
		x 250
		y 115
		view 30091
	)

	(method (init)
		(super init: &rest)
		((gUser primaDonnas:) add: self)
	)

	(method (doit)
		(if (and (< nrg 100) (not (Random 0 50)))
			(++ nrg)
			(eText new:)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (== loop 5)
			(return)
		)
		(= temp0 dX)
		(= temp1 dY)
		(= temp2 dT)
		(cond
			((& (event type:) evKEYBOARD)
				(switch (event message:)
					(KEY_UP
						(+=
							temp0
							(cond
								((OneOf cel 1 2 3) 1)
								((OneOf cel 5 6 7) -1)
								(else 0)
							)
						)
						(+=
							temp1
							(cond
								((OneOf cel 7 0 1) -1)
								((OneOf cel 3 4 5) 1)
								(else 0)
							)
						)
						(= dT (= temp2 0))
					)
					(KEY_DOWN
						(-=
							temp0
							(cond
								((OneOf cel 1 2 3) 1)
								((OneOf cel 5 6 7) -1)
								(else 0)
							)
						)
						(-=
							temp1
							(cond
								((OneOf cel 7 0 1) -1)
								((OneOf cel 3 4 5) 1)
								(else 0)
							)
						)
						(= dT (= temp2 0))
					)
					(KEY_LEFT
						(-- temp2)
					)
					(KEY_RIGHT
						(++ temp2)
					)
					(KEY_SPACE
						(= pendP phaser)
					)
					(KEY_RETURN
						(= pendP photon)
					)
					(KEY_z
						(= x (Random local0 local2))
						(= y (Random local1 local3))
						(= dX (= dY (= dT 0)))
						(/= nrg 2)
						(eText new:)
					)
					(KEY_Z
						(= x (Random local0 local2))
						(= y (Random local1 local3))
						(= dX (= dY (= dT 0)))
						(/= nrg 2)
						(eText new:)
					)
				)
			)
			(
				(and
					(& (event type:) evKEYUP)
					(OneOf (event message:) KEY_LEFT KEY_RIGHT)
				)
				(= dT (= temp2 0))
			)
		)
		(if (<= (Abs temp0) 5)
			(= dX temp0)
		)
		(if (<= (Abs temp1) 5)
			(= dY temp1)
		)
		(if (<= (Abs temp2) 1)
			(= dT temp2)
		)
	)

	(method (kaBoom)
		([local16 3] play:)
		(= local11 15)
		(super kaBoom: &rest)
	)

	(method (dispose)
		(= local6 1)
		((gUser primaDonnas:) delete: self)
		(trekS seconds: 1)
		(-- local7)
		(= local10 0)
		(super dispose:)
	)
)

(instance phaser of Wessel
	(properties
		view 30091
		loop 1
		spd 1
	)

	(method (init param1)
		(= name (param1 name:))
		(super init: &rest)
		([local16 0] play:)
		(self setCel: (param1 cel:) posn: (param1 x:) (param1 y:))
		(= dX
			(cond
				((OneOf cel 1 2 3) 5)
				((OneOf cel 5 6 7) -5)
				(else 0)
			)
		)
		(= dY
			(cond
				((OneOf cel 3 4 5) 5)
				((OneOf cel 7 0 1) -5)
				(else 0)
			)
		)
		(local9 add: self)
	)

	(method (move &tmp temp0 temp1 temp2)
		(= temp0 dX)
		(= temp1 dY)
		(super move:)
		(cond
			((or (!= temp0 dX) (!= temp1 dY))
				(= killMe 1)
			)
			((and local10 (local10 contains: self))
				(local10 nrg: (- (local10 nrg:) 5))
				(eText new:)
				(= killMe 1)
				(+= local11 3)
			)
			((= temp2 (local8 firstTrue: #contains self))
				(temp2 nrg: (- (temp2 nrg:) 5))
				(= killMe 1)
			)
		)
	)

	(method (dispose)
		(local9 delete: self)
		(super dispose:)
	)
)

(instance photon of Wessel
	(properties
		view 30091
		loop 2
		spd 3
	)

	(method (init param1)
		(= name (param1 name:))
		(super init: &rest)
		([local16 1] play:)
		(self setCel: 0 posn: (param1 x:) (param1 y:))
		(= dX
			(cond
				((OneOf (param1 cel:) 1 2 3) 10)
				((OneOf (param1 cel:) 5 6 7) -10)
				(else 0)
			)
		)
		(= dY
			(cond
				((OneOf (param1 cel:) 3 4 5) 10)
				((OneOf (param1 cel:) 7 0 1) -10)
				(else 0)
			)
		)
		(local9 add: self)
	)

	(method (move &tmp temp0 temp1 temp2)
		(= temp0 dX)
		(= temp1 dY)
		(super move:)
		(if (< cel 1)
			(cond
				(
					(or
						(!= temp0 dX)
						(!= temp1 dY)
						(and local10 (local10 contains: self))
						(local8 firstTrue: #contains self)
						(and (== dX 0) (== dY 0))
					)
					(self setCel: 1)
					([local16 2] play:)
				)
				((not (Random 0 2))
					(if (> dX 0)
						(-- dX)
					)
					(if (> dY 0)
						(-- dY)
					)
					(if (< dX 0)
						(++ dX)
					)
					(if (< dY 0)
						(++ dY)
					)
				)
			)
		else
			(= name {blast})
			(= spd 3)
			(= dX (= dY 0))
			(= dT 1)
			(cond
				((== cel 7)
					(= killMe 1)
				)
				((and local10 (local10 contains: self))
					(local10 nrg: (- (local10 nrg:) 5))
					(eText new:)
					(+= local11 5)
				)
				((= temp2 (local8 firstTrue: #contains self))
					(temp2 nrg: (- (temp2 nrg:) 5))
				)
			)
		)
	)

	(method (dispose)
		(local9 delete: self)
		(super dispose:)
	)
)

(instance enemy of Wessel
	(properties
		view 30091
		loop 3
		spd 7
		nrg 10
	)

	(method (init)
		(++ local4)
		(super init: &rest)
		(self posn: (Random local0 local2) (Random local1 local3))
		(self setCel: (Random 0 7))
		(if (> local21 (Random 0 1000))
			(self setLoop: 4)
			(= nrg 50)
			(= spd 5)
		)
		(local8 add: self)
	)

	(method (move &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 0)
		(if (!= loop 5)
			(if local6
				(= dX (= dT (= pendP 0)))
				(self setCel: 0)
				(= dY -3)
				(= spd 1)
			else
				(= temp0 (/ (+ (sign (- (local10 x:) x)) 1) 2))
				(= temp1 (/ (+ (sign (- (local10 y:) y)) 1) 2))
				(= temp2 (+ temp0 (* 2 temp1)))
				(switch cel
					(0
						(if (> dY -3)
							(-- dY)
						)
						(= dX 0)
						(switch temp2
							(0
								(= temp4 -1)
								(= temp3 1)
							)
							(1
								(= temp4 1)
								(= temp3 1)
							)
							(2
								(= temp4 -1)
							)
							(3
								(= temp4 1)
							)
						)
					)
					(1
						(if (> dY -3)
							(-- dY)
						)
						(if (< dX 3)
							(++ dX)
						)
						(switch temp2
							(0
								(= temp4 -1)
							)
							(1
								(= temp4 0)
								(= temp3 1)
							)
							(2
								(= temp4 1)
							)
							(3
								(= temp4 1)
							)
						)
					)
					(2
						(if (< dX 3)
							(++ dX)
						)
						(= dY 0)
						(switch temp2
							(0
								(= temp4 -1)
							)
							(1
								(= temp4 -1)
								(= temp3 1)
							)
							(2
								(= temp4 1)
							)
							(3
								(= temp4 1)
								(= temp3 1)
							)
						)
					)
					(3
						(if (< dY 3)
							(++ dY)
						)
						(if (< dX 3)
							(++ dX)
						)
						(switch temp2
							(0
								(= temp4 -1)
							)
							(1
								(= temp4 -1)
							)
							(2
								(= temp4 1)
							)
							(3
								(= temp4 0)
								(= temp3 1)
							)
						)
					)
					(4
						(if (< dY 3)
							(++ dY)
						)
						(= dX 0)
						(switch temp2
							(0
								(= temp4 1)
							)
							(1
								(= temp4 -1)
							)
							(2
								(= temp4 1)
								(= temp3 1)
							)
							(3
								(= temp4 -1)
								(= temp3 1)
							)
						)
					)
					(5
						(if (< dY 3)
							(++ dY)
						)
						(if (> dX 3)
							(-- dX)
						)
						(switch temp2
							(0
								(= temp4 1)
							)
							(1
								(= temp4 1)
							)
							(2
								(= temp4 0)
								(= temp3 1)
							)
							(3
								(= temp4 -1)
							)
						)
					)
					(6
						(if (> dX -3)
							(-- dX)
						)
						(= dY 0)
						(switch temp2
							(0
								(= temp4 1)
								(= temp3 1)
							)
							(1
								(= temp4 1)
							)
							(2
								(= temp4 -1)
								(= temp3 1)
							)
							(3
								(= temp4 -1)
							)
						)
					)
					(7
						(if (> dY -3)
							(-- dY)
						)
						(if (> dX -3)
							(-- dX)
						)
						(switch temp2
							(0
								(= temp4 0)
								(= temp3 1)
							)
							(1
								(= temp4 1)
							)
							(2
								(= temp4 -1)
							)
							(3
								(= temp4 1)
							)
						)
					)
					(else 0)
				)
				(= dT (if (Random 0 1) temp4 else 0))
				(if (and temp3 (not (Random 0 5)))
					(if (== loop 3)
						(= pendP phaser)
					else
						(= pendP photon)
					)
				)
			)
		)
		(super move:)
		(if (and local6 (<= y local1))
			(= killMe 1)
		)
	)

	(method (kaBoom)
		([local16 4] play:)
		(+= local21 (if (== loop 3) 10 else 25))
		(scrText new:)
		(super kaBoom: &rest)
	)

	(method (dispose)
		(-- local4)
		(local8 delete: self)
		(super dispose:)
	)
)

(instance shaker of Obj
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp4 (if (Random 0 1) 1 else -1))
		(= temp5 (if (Random 0 1) 1 else -1))
		(= temp0 (+ local12 (* temp4 local11)))
		(= temp1 (+ local13 (* temp5 local11)))
		(= temp2 (+ local14 (* temp4 local11)))
		(= temp3 (+ local15 (* temp5 local11)))
		(gThePlane setRect: temp0 temp1 temp2 temp3 update:)
		(if local11
			(-- local11)
		)
	)
)

(instance bSound of Sound
	(properties)

	(method (play)
		(if (== (DoAudio audPOSITION number) -1)
			(self stop:)
			(super play:)
		)
	)
)

(instance scrText of TextView
	(properties)

	(method (new)
		(if local22
			(local22 dispose:)
		)
		(= local22 (super new:))
		(local22 init:)
	)

	(method (init &tmp temp0)
		(= temp0 (Str format: {Score: %d} local21))
		(self setText: (temp0 data:) setSize: posn: 565 100)
		(temp0 data: 0 dispose:)
		(super init: gThePlane)
	)
)

(instance eText of TextView
	(properties)

	(method (new)
		(if local23
			(local23 dispose:)
		)
		(= local23 (super new:))
		(local23 init:)
	)

	(method (init &tmp temp0)
		(= temp0 (Str format: {Energy: %d} (Max 0 (local10 nrg:))))
		(self setText: (temp0 data:) setSize: posn: 565 120)
		(temp0 data: 0 dispose:)
		(super init: gThePlane)
	)
)

