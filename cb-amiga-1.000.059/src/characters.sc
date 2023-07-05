;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 778)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	characters 0
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
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	[local23 158] = [1 0 0 160 922 1 -6 -39 10 25 0 5 160 62 3 0 0 160 920 1 -1 -39 5 15 0 0 252 918 1 -4 -42 5 15 0 0 72 923 1 -4 -38 5 15 8 5 7 5 9 5 187 65 213 60 131 78 3 0 0 160 912 1 5 -46 5 15 0 0 72 917 1 3 -39 5 15 0 0 252 916 1 -11 -34 5 15 2 5 4 6 3 18 80 67 105 64 53 74 2 0 0 97 921 1 -3 -41 5 15 0 0 220 913 1 -3 -37 5 15 10 5 1 5 238 75 265 60 2 0 0 240 915 1 -1 -41 5 15 0 0 77 919 1 -4 -38 5 15 6 5 5 5 292 71 26 63 1 0 0 156 23 1 1 -32 5 15]
	local181
	local182
	local183
	local184
	local185
	local186
	[local187 24] = [778 0 778 1 778 2 778 3 778 4 778 5 778 6 778 7 778 8 778 9 778 10 778 11]
	local211
)

(procedure (localproc_0)
	(= local2 (Display &rest dsFONT 4 dsALIGN alCENTER dsCOORD 1 90 dsWIDTH 320 dsCOLOR 15 dsSAVEPIXELS))
)

(procedure (localproc_1)
	(= local1 (Display &rest dsFONT 8 dsALIGN alCENTER dsCOORD 1 165 dsWIDTH 320 dsCOLOR 15 dsSAVEPIXELS))
)

(procedure (localproc_2)
	(Display 778 12 dsRESTOREPIXELS local2)
)

(procedure (localproc_3)
	(Display 778 12 dsRESTOREPIXELS local1)
)

(procedure (localproc_4)
	(= local3 (Display &rest dsFONT 41 dsALIGN alCENTER dsCOORD local5 local6 dsWIDTH 300 dsCOLOR 0 dsSAVEPIXELS))
)

(procedure (localproc_5)
	(= local4 (Display &rest dsFONT 41 dsALIGN alCENTER dsCOORD local5 local6 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS))
)

(procedure (localproc_6)
	(Display 778 12 dsRESTOREPIXELS local3)
)

(procedure (localproc_7)
	(Display 778 12 dsRESTOREPIXELS local4)
)

(instance Colonel of Act
	(properties)
)

(instance Ethel of Act
	(properties)
)

(instance Gertie of Act
	(properties)
)

(instance Gloria of Act
	(properties)
)

(instance Rudy of Act
	(properties)
)

(instance Clarence of Act
	(properties)
)

(instance Wilbur of Act
	(properties)
)

(instance Lillian of Act
	(properties)
)

(instance Fifi of Act
	(properties)
)

(instance Jeeves of Act
	(properties)
)

(instance Celie of Act
	(properties)
)

(instance Laura of Act
	(properties)
)

(instance features1 of Prop
	(properties)
)

(instance features2 of Prop
	(properties)
)

(instance features3 of Prop
	(properties)
)

(instance Mask1 of Prop
	(properties)
)

(instance Mask2 of Prop
	(properties)
)

(instance Mask3 of Prop
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance characters of Rm
	(properties
		picture 888
		style 8
	)

	(method (init)
		(= global61 1)
		(super init:)
		(HandsOff)
		(LoadMany rsFONT 4 8 41)
		(Load rsSOUND 1)
		(LoadMany rsVIEW 912 913 914 915 916 917 918 919 920 921 922 923 23)
		(= local7 Colonel)
		(= local8 Fifi)
		(= local9 Jeeves)
		(= local10 Celie)
		(= local11 Gertie)
		(= local12 Rudy)
		(= local13 Gloria)
		(= local14 Ethel)
		(= local15 Lillian)
		(= local16 Clarence)
		(= local17 Wilbur)
		(= local18 Laura)
		(Mask1 view: 914 loop: 0 cel: 0 y: 161 setPri: 15 init: stopUpd: hide:)
		(Mask2 view: 914 loop: 0 cel: 0 y: 161 setPri: 15 init: stopUpd: hide:)
		(Mask3 view: 914 loop: 0 cel: 0 y: 161 setPri: 15 init: stopUpd: hide:)
		(self setScript: showPlay)
	)

	(method (newRoom newRoomNumber)
		(= global61 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(cond
					((or (== (event message:) KEY_S) (== (event message:) KEY_s))
						(gCurRoom newRoom: 779) ; Tulane
					)
					((or (== (event message:) KEY_RETURN) (== (event message:) KEY_SPACE))
						(SetFlag 50)
					)
				)
			)
			(evMOUSEBUTTON
				(SetFlag 50)
			)
		)
		(if (IsFlag 50)
			(event claimed: 1)
			(gCurRoom newRoom: 44)
		)
	)
)

(instance showPlay of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (myMusic prevSignal:) -1)
			(client setScript: 0)
			(gCurRoom newRoom: 779) ; Tulane
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myMusic number: 1 loop: -1 play:)
				(= local5 11)
				(= local6 17)
				(localproc_4 778 13) ; "Executive Producer  Ken Williams"
				(= local5 10)
				(= local6 15)
				(localproc_5 778 13) ; "Executive Producer  Ken Williams"
				(= seconds 5)
			)
			(1
				(localproc_7)
				(localproc_6)
				(= local5 11)
				(= local6 17)
				(localproc_4 778 14) ; "Written by  Roberta Williams"
				(= local5 10)
				(= local6 15)
				(localproc_5 778 14) ; "Written by  Roberta Williams"
				(= seconds 5)
			)
			(2
				(if (== local0 0)
					(localproc_7)
					(localproc_6)
					(= local186 0)
					(= local19 (= local181 (= local211 -1)))
				)
				(if (== global61 1)
					(= global61 0)
					(DrawPic 888 8 1 0)
				)
				(= local20 [local7 (++ local19)])
				(= local185 [local23 (++ local181)])
				(local20
					view:
						(switch local0
							(0 922)
							(1 920)
							(2 912)
							(3 921)
							(4 915)
							(5 23)
						)
					loop: [local23 (++ local181)]
					cel: [local23 (++ local181)]
					x: [local23 (++ local181)]
					y: 161
					init:
					stopUpd:
					setScript: Features1
					show:
				)
				(Mask1 x: [local23 local181])
				(+= local181 6)
				(if (>= local185 2)
					(= local21 [local7 (++ local19)])
					(local21
						view:
							(switch local0
								(1 918)
								(2 917)
								(3 913)
								(4 919)
							)
						loop: [local23 (++ local181)]
						cel: [local23 (++ local181)]
						x: [local23 (++ local181)]
						y: 161
						init:
						stopUpd:
						setScript: Features2
						show:
					)
					(Mask2 x: [local23 local181])
					(+= local181 6)
				)
				(if (== local185 3)
					(= local22 [local7 (++ local19)])
					(local22
						view:
							(switch local0
								(1 923)
								(2 916)
							)
						loop: [local23 (++ local181)]
						cel: [local23 (++ local181)]
						x: [local23 (++ local181)]
						y: 161
						init:
						stopUpd:
						setScript: Features3
						show:
					)
					(Mask3 x: [local23 local181])
					(+= local181 6)
				)
				(localproc_0 [local187 (++ local211)] [local187 (++ local211)])
				(localproc_1 [local187 (++ local211)] [local187 (++ local211)])
				(if (== local0 5)
					(= state 6)
				)
				(= seconds 5)
			)
			(3
				(localproc_3)
				(localproc_2)
				(local20 setScript: 0)
				(features1 setCycle: 0 hide:)
				(Mask1 show: setCycle: End self)
				(if (>= local185 2)
					(local21 setScript: 0)
					(features2 setCycle: 0 hide:)
					(Mask2 show: setCycle: End)
				)
				(if (== local185 3)
					(local22 setScript: 0)
					(features3 setCycle: 0 hide:)
					(Mask3 show: setCycle: End)
				)
			)
			(4
				(local20
					view:
						(switch local0
							(0 922)
							(1 920)
							(2 912)
							(3 921)
							(4 915)
							(5 23)
						)
					setLoop: 2
					setCel: [local23 (++ local181)]
				)
				(++ local181)
				(local20 setStep: [local23 local181] [local23 local181])
				(Mask1 setCycle: Beg self)
				(if (>= local185 2)
					(local21
						view:
							(switch local0
								(1 918)
								(2 917)
								(3 913)
								(4 919)
							)
						setLoop: 2
						setCel: [local23 (++ local181)]
					)
					(++ local181)
					(local21 setStep: [local23 local181] [local23 local181])
					(Mask2 setCycle: Beg)
				)
				(if (== local185 3)
					(local22
						view:
							(switch local0
								(1 923)
								(2 916)
							)
						setLoop: 2
						setCel: [local23 (++ local181)]
					)
					(++ local181)
					(local22 setStep: [local23 local181] [local23 local181])
					(Mask3 setCycle: Beg)
				)
			)
			(5
				(local20
					setMotion:
						MoveTo
						[local23 (++ local181)]
						[local23 (++ local181)]
						self
				)
				(Mask1 stopUpd: hide:)
				(if (>= local185 2)
					(local21
						setMotion:
							MoveTo
							[local23 (++ local181)]
							[local23 (++ local181)]
					)
					(Mask2 stopUpd: hide:)
				)
				(if (== local185 3)
					(local22
						setMotion:
							MoveTo
							[local23 (++ local181)]
							[local23 (++ local181)]
					)
					(Mask3 stopUpd: hide:)
				)
			)
			(6
				(local20 stopUpd:)
				(if (>= local185 2)
					(local21 stopUpd:)
				)
				(if (== local185 3)
					(local22 stopUpd:)
				)
				(++ local0)
				(= state 1)
				(= cycles 7)
			)
			(7
				(myMusic fade:)
			)
		)
	)
)

(instance Features1 of Script
	(properties)

	(method (init)
		(= local182 local181)
		(super init:)
	)

	(method (changeState newState)
		(^= local186 $0001)
		(switch (= state newState)
			(0
				(features1
					view: [local23 (++ local182)]
					loop: [local23 (++ local182)]
					x: (+ [local23 (- local182 2)] [local23 (++ local182)])
					y: (+ 161 [local23 (++ local182)])
					setPri: 14
					ignoreActors: 1
					init:
				)
				(features1
					cel:
						(if (== local0 5)
							(= local186 0)
						else
							(* (- (NumCels features1) 1) local186)
						)
					cycleSpeed: 3
					setCycle: (if local186 Beg else End) self
					show:
				)
			)
			(1
				(= cycles (Random [local23 (++ local182)] [local23 local182]))
			)
			(2
				(features1
					loop:
						(if (== local0 5)
							2
						else
							(features1 loop:)
						)
					setCycle:
						(if (== (features1 cel:) (- (NumCels features1) 1))
							Beg
						else
							End
						)
						self
				)
				(= state 0)
			)
		)
	)
)

(instance Features2 of Script
	(properties)

	(method (init)
		(= local183 local181)
		(super init:)
	)

	(method (changeState newState)
		(^= local186 $0001)
		(switch (= state newState)
			(0
				(features2
					view: [local23 (++ local183)]
					loop: [local23 (++ local183)]
					x: (+ [local23 (- local183 2)] [local23 (++ local183)])
					y: (+ 161 [local23 (++ local183)])
					setPri: 14
					ignoreActors: 1
					init:
				)
				(features2
					cel: (* (- (NumCels features2) 1) local186)
					cycleSpeed: 3
					setCycle: (if local186 Beg else End) self
					show:
				)
			)
			(1
				(= cycles (Random [local23 (++ local183)] [local23 local183]))
			)
			(2
				(features2
					setCycle:
						(if (== (features2 cel:) (- (NumCels features2) 1))
							Beg
						else
							End
						)
						self
				)
				(= state 0)
			)
		)
	)
)

(instance Features3 of Script
	(properties)

	(method (init)
		(= local184 local181)
		(super init:)
	)

	(method (changeState newState)
		(^= local186 $0001)
		(switch (= state newState)
			(0
				(features3
					view: [local23 (++ local184)]
					loop: [local23 (++ local184)]
					x: (+ [local23 (- local184 2)] [local23 (++ local184)])
					y: (+ 161 [local23 (++ local184)])
					setPri: 14
					ignoreActors: 1
					init:
				)
				(features3
					cel: (* (- (NumCels features3) 1) local186)
					cycleSpeed: 3
					setCycle: (if local186 Beg else End) self
					show:
				)
			)
			(1
				(= cycles (Random [local23 (++ local184)] [local23 local184]))
			)
			(2
				(features3
					setCycle:
						(if (== (features3 cel:) (- (NumCels features3) 1))
							Beg
						else
							End
						)
						self
				)
				(= state 0)
			)
		)
	)
)

