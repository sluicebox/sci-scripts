;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)

(public
	Rm26 0
)

(local
	local0
	local1
	local2
)

(instance Rm26 of eRoom
	(properties
		picture 26
		style 8
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 917)
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(27
				(self enterRoom: 110 -5 (= local1 110) (= local2 60))
			)
			(else
				(self enterRoom: 140 235 (= local1 140) (= local2 182))
			)
		)
		(= local0 0)
		(self setRegions: 106) ; otMoor
		(proc0_13 33)
		(gAddToPics doit:)
	)

	(method (doit &tmp [temp0 100])
		(super doit:)
		(cond
			((or global119 global118) 0)
			((>= local0 5)
				((ScriptID 106) notify: 1) ; otMoor
			)
			(
				(or
					(and
						(== (gEgo loop:) 3)
						(< (gEgo y:) 160)
						(> (- local2 (gEgo y:)) 8)
					)
					(and
						(== (gEgo loop:) 0)
						(> (gEgo x:) 170)
						(> (- (gEgo x:) local1) 14)
					)
					(and
						(== (gEgo loop:) 1)
						(< (gEgo x:) 110)
						(> (- local1 (gEgo x:)) 14)
					)
				)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(++ local0)
				((ScriptID 106) notify: 0) ; otMoor
			)
		)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((> (gEgo y:) 185)
					(self leaveRoom: 25 (gEgo x:) 235)
				)
				((< (gEgo y:) 40)
					(self leaveRoom: 27 (gEgo x:) -5)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(OnButton event 67 124 102 139)
					(OnButton event 188 70 272 96)
				)
				(Print 26 0) ; "You can observe ice pushed upward into a ridge by the pressure of freezing too quickly."
			)
		)
	)
)

