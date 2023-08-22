;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use n096)
(use Interface)
(use Motion)
(use File)
(use Game)
(use Actor)
(use System)

(public
	morning 0
)

(local
	local0
	[local1 2]
)

(procedure (localproc_0 &tmp [temp0 250] [temp250 100] temp350 temp351 temp352 [temp353 13] temp366 temp367)
	(= temp352 (GetSaveFiles (gGame name:) @temp0 @temp353))
	((= temp350 (File new:))
		name: (DeviceInfo 7 @temp250 (gGame name:)) ; MakeSaveDirName
		open: 2
	)
	(= temp351 2570)
	(for ((= temp366 0)) (< temp366 temp352) ((++ temp366))
		(if (!= [temp353 temp366] gSaveSlot)
			(temp350 write: @[temp353 temp366] 2)
			(temp350 writeString: @[temp0 (* temp366 18)])
			(temp350 write: @temp351 1)
		else
			(= temp367 temp366)
		)
	)
	(= temp351 -1)
	(temp350 write: @temp351 2 close: dispose:)
	(DeviceInfo 8 @temp250 (gGame name:) [temp353 temp367]) ; MakeSaveFileName
	(FileIO fiUNLINK @temp250)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 18) ((++ temp0))
		((gGoals at: temp0) egoReturned: 0 egoTold: 0 egoSeen: 0 egoHas: 0)
	)
	(for ((= temp0 1)) (<= temp0 44) ((++ temp0))
		(= [global200 temp0] 0)
	)
	(for ((= temp0 41)) (<= temp0 60) ((++ temp0))
		(if (and (!= temp0 53) (!= temp0 43))
			(proc96_1 temp0)
		)
	)
	(= global113 0)
	(= gScore 0)
)

(instance morning of Rm
	(properties
		picture 60
	)

	(method (init &tmp temp0)
		(= global124 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX 0 0 200 320 2 0 0 0)
		(Graph grFILL_BOX 0 0 200 320 1 0 0 0)
		(Graph grUPDATE_BOX 0 0 200 320 1)
		(SetPort 0 0 189 319 0 0)
		(if (= local0 (== (mod global114 2) 0))
			(= picture 61)
			(train init:)
			(ball init:)
			(mitt init:)
		else
			(doll init:)
			(shoes init:)
		)
		(child init:)
		(deskTop init:)
		(photo init:)
		(book init:)
		(gCast eachElementDo: #stopUpd)
		(sun init:)
		(bird init:)
		(childEyes init:)
		(super init: &rest)
		(self setScript: sunrise)
		(= global104 0)
		(= global176 1)
		(Animate (gCast elements:) 1)
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 4))
			(Palette palSET_INTENSITY 0 255 temp0)
			(Wait 2)
		)
	)

	(method (dispose)
		(gCast eachElementDo: #dispose eachElementDo: #delete release:)
		(DisposeScript 993)
		(RedrawCast)
		(gCast release:)
		(super dispose: &rest)
	)
)

(instance sunrise of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gLongSong stop: prevSignal: 0 number: 602 loop: 1 play:)
				(sun setCycle: End self)
			)
			(2
				(sun stopUpd:)
				(bird setCycle: Fwd)
				(= cycles 10)
			)
			(3
				(if (!= (gLongSong prevSignal:) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(bird setCycle: CT 0 1 self)
			)
			(5
				(bird stopUpd:)
				(= cycles 2)
			)
			(6
				(gEgo posn: 92 116)
				(gGame setCursor: global75 1)
				(if global188
					(localproc_0)
					(= global188 0)
				)
				(switch
					(Print 94 0 #mode 1 #button {Play another game} 0 #button {Quit} 1) ; "You finished!!"
					(0
						(localproc_1)
						(gCurRoom newRoom: 90) ; intro
					)
					(1
						(= gQuit 1)
					)
				)
			)
		)
	)
)

(instance sun of Prop
	(properties
		x 159
		y 99
		view 873
		cycleSpeed 30
	)

	(method (init)
		(super init: &rest)
		(if local0
			(self posn: 158 100)
		)
	)
)

(instance bird of Prop
	(properties
		x 138
		y 98
		view 873
		loop 1
		priority 11
		signal 16
		cycleSpeed 14
	)

	(method (init)
		(super init: &rest)
		(if local0
			(self posn: 137 99)
		)
	)
)

(instance book of View
	(properties
		x 278
		y 115
		view 891
		loop 2
	)

	(method (init)
		(if local0
			(= view 870)
			(= x 276)
			(= y 116)
			(= loop 5)
		)
		(super init: &rest)
	)
)

(instance deskTop of View
	(properties
		x 21
		y 145
		view 890
		loop 4
	)

	(method (init)
		(if local0
			(= view 871)
			(= x 20)
			(= y 137)
			(= loop 0)
		)
		(super init: &rest)
	)
)

(instance train of View
	(properties
		x 218
		y 166
		view 870
		loop 3
		cel 13
	)
)

(instance photo of View
	(properties
		x 250
		y 82
		view 891
		loop 3
	)

	(method (init)
		(if local0
			(= view 871)
			(= y 82)
			(= loop 4)
		)
		(super init: &rest)
	)
)

(instance ball of View
	(properties
		x 238
		y 91
		view 870
	)
)

(instance mitt of View
	(properties
		x 245
		y 137
		view 870
		loop 1
	)
)

(instance doll of View
	(properties
		x 243
		y 142
		view 890
	)
)

(instance shoes of View
	(properties
		x 110
		y 182
		view 890
		loop 3
	)
)

(instance child of View
	(properties
		x 76
		y 128
	)

	(method (init)
		(if local0
			(= x 73)
			(= y 128)
		)
		(= view (+ 850 global114))
		(super init: &rest)
	)
)

(instance childEyes of Prop
	(properties
		x 83
		y 103
		loop 1
		priority 14
		signal 16
	)

	(method (init)
		(if local0
			(= view 900)
			(= x 83)
			(= y 103)
		)
		(= view (child view:))
		(super init: &rest)
		(self setScript: blink)
	)
)

(instance blink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(childEyes cel: 0 setCycle: End self)
			)
			(1
				(childEyes setCycle: Beg)
				(= state -1)
				(= seconds (Random 3 5))
			)
		)
	)
)

