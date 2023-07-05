;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use Interface)
(use CPath)
(use Chase)
(use Avoid)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	monkAttack 0
	monk1 1
	monk2 2
	monk3 3
	madMonkFightingWindow 4
)

(local
	local0
	local1
	local2
	[local3 4] = [0 -25 -15 -15]
	[local7 4] = [-10 -10 0 -20]
	[local11 4] = [25 0 15 15]
	[local15 4] = [10 10 20 0]
	[local19 29] = [166 88 100 88 93 120 40 120 93 120 144 168 192 168 218 130 275 130 218 130 190 114 166 114 163 78 196 78 -32768]
	[local48 29] = [151 61 98 69 78 89 40 89 78 89 153 89 175 111 159 137 105 137 228 133 275 133 228 133 198 127 180 109 -32768]
	[local77 23] = [174 117 220 133 275 133 220 133 193 119 107 157 99 125 40 125 99 125 99 95 153 87 -32768]
	[local100 13] = [142 118 230 139 154 112 52 104 50 118 139 110 -32768]
	[local113 15] = [139 106 53 144 14 117 64 81 211 83 206 113 143 113 -32768]
	[local128 19] = [143 111 174 131 82 151 82 101 99 134 161 159 217 140 175 100 144 114 -32768]
	[local147 13] = [148 102 192 142 102 142 70 110 42 138 100 104 -32768]
	[local160 13] = [140 112 118 134 86 160 206 160 257 126 180 106 -32768]
	[local173 17] = [148 112 100 112 100 98 55 116 85 146 159 132 187 148 207 98 -32768]
)

(instance genericMonkScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== cycles 0)
				(== state 0)
				(< (client distanceTo: gEgo) 40)
				(== (gEgo onControl: 1) 1)
			)
			(self changeState: 1)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(client view: 338 setCycle: Walk setMotion: register)
			)
			(1
				(client setMotion: Chase gEgo 20 self)
			)
			(2
				(= cycles 40)
				(client view: 339 setCel: 0 setCycle: End self)
			)
			(3
				(client setCycle: CT 1 -1 self)
			)
			(4
				(self changeState: 0)
			)
			(5
				(gTObj noWidth: 1)
				(Talk 111 0) ; "OW!"
				(self changeState: 0)
			)
			(6
				(client
					view: 340
					setLoop: 1
					cel: 0
					setMotion: 0
					setAvoider: 0
					setCycle: End
				)
			)
		)
	)
)

(instance monk1 of Act
	(properties
		yStep 4
		signal 16384
		illegalBits -8190
		xStep 6
	)

	(method (init &tmp temp0)
		(super init:)
		(switch gCurRoomNum
			(18
				(self posn: [local19 0] [local19 1])
			)
			(21
				(self posn: [local147 0] [local147 1])
			)
			(else
				(self posn: [local100 0] [local100 1])
			)
		)
		(= temp0 (Clone genericMonkScript))
		(temp0 register: monk1Path)
		(self setAvoider: (Avoid new:) setScript: temp0)
	)
)

(instance monk2 of Act
	(properties
		yStep 4
		signal 16384
		illegalBits -8190
		xStep 6
	)

	(method (init &tmp temp0)
		(super init:)
		(switch gCurRoomNum
			(18
				(self posn: [local48 0] [local48 1])
			)
			(21
				(self posn: [local160 0] [local160 1])
			)
			(else
				(self posn: [local113 0] [local113 1])
			)
		)
		(= temp0 (Clone genericMonkScript))
		(temp0 register: monk2Path)
		(self setAvoider: (Avoid new:) setScript: temp0)
	)
)

(instance monk3 of Act
	(properties
		yStep 4
		signal 16384
		illegalBits -8190
		xStep 6
	)

	(method (init &tmp temp0)
		(super init:)
		(switch gCurRoomNum
			(18
				(self posn: [local77 0] [local77 1])
			)
			(21
				(self posn: [local173 0] [local173 1])
			)
			(else
				(self posn: [local128 0] [local128 1])
			)
		)
		(= temp0 (Clone genericMonkScript))
		(temp0 register: monk3Path)
		(self setAvoider: (Avoid new:) setScript: temp0)
	)
)

(instance monk1Path of CPath
	(properties)

	(method (at param1)
		(return
			(switch gCurRoomNum
				(18 [local19 param1])
				(19 [local100 param1])
				(21 [local147 param1])
			)
		)
	)
)

(instance monk2Path of CPath
	(properties)

	(method (at param1)
		(return
			(switch gCurRoomNum
				(18 [local48 param1])
				(19 [local113 param1])
				(21 [local160 param1])
			)
		)
	)
)

(instance monk3Path of CPath
	(properties)

	(method (at param1)
		(return
			(switch gCurRoomNum
				(18 [local77 param1])
				(19 [local128 param1])
				(21 [local173 param1])
			)
		)
	)
)

(instance madMonkFightingWindow of SysWindow
	(properties
		color 15
		back 6
		title {Mad Monk}
		brTop 10
		brLeft 60
		brBottom 50
		brRight 250
	)
)

(instance monkAttack of Rgn
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 972)
		(DisposeScript 917)
		(DisposeScript 985)
	)

	(method (init)
		(Load rsVIEW 338)
		(Load rsVIEW 339)
		(Load rsVIEW 340)
		(Load rsVIEW 22)
		(Load rsVIEW 4)
		(Load rsVIEW 53)
		(Load rsVIEW 23)
		(Load rsSOUND 6)
		(Load rsSOUND 25)
		(super init:)
		(= global109 6)
		(if (not (IsFlag 59))
			(SetFlag 59)
			(self setScript: monkWarning)
		)
		(monk1 init:)
		(monk2 init:)
		(monk3 init:)
		(gTObj tWindow: madMonkFightingWindow actor: 0)
		(gSFX init:)
		(= global113
			(switch (Random 1 3)
				(1 monk1)
				(2 monk2)
				(3 monk3)
			)
		)
		(global113 ignoreActors: 0)
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
					(Said 'look[<at,around][/!*][/!*]')
					(Said 'look/room[/!*]')
					(Said 'look/glastenbury,glastenbury,ruin')
				)
				(Print 111 1) ; "Deal with the Mad Monk and his illusions! Then you will have time to look around."
			)
			(
				(or
					(MouseClaimed global113 event)
					(MouseClaimed monk1 event)
					(MouseClaimed monk2 event)
					(MouseClaimed monk3 event)
				)
				(if (IsFlag 49)
					(Print 111 2) ; "Like a mad dog, he has been destroyed. Tragic, but necessary."
				else
					(Print 111 3) ; "Arthur, beware! Two of these monks are illusions, but one is deadly!"
				)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(cond
			(local1 0)
			((and (== global125 4) (== (gEgo cel:) (- (NumCels gEgo) 1)))
				(= temp0 (gEgo loop:))
				(if
					(and
						(== (gEgo onControl: 1) 1)
						(global113
							inRect:
								(+ (gEgo x:) [local3 temp0])
								(+ (gEgo y:) [local7 temp0])
								(+ (gEgo x:) [local11 temp0])
								(+ (gEgo y:) [local15 temp0])
						)
					)
					(gSFX number: (proc0_20 6) loop: 1 priority: 15 play:)
					(= temp1 (+ 2 (- 3 global108)))
					(SetScore 0 0 (- 4 global108))
					(if (>= (++ local0) temp1)
						(= local1 1)
						(= global109 0)
						(SetScore 0 0 (- 4 global108))
						(monk1 setMotion: 0 setAvoider: 0)
						(monk2 setMotion: 0 setAvoider: 0)
						(monk3 setMotion: 0 setAvoider: 0)
						(= global125 0)
						(DisposeScript 912)
						(DisposeScript 972)
						(DisposeScript 985)
						(gEgo
							setScript: 0
							illegalBits: -32768
							setCycle: Walk
						)
						(self setScript: (ScriptID 134 1)) ; monkDead
					else
						((global113 script:) changeState: 5)
					)
				)
			)
		)
		(cond
			(local1 0)
			(
				(and
					(== (global113 view:) 339)
					(== (global113 cel:) 2)
					(not (and (== (gEgo view:) 53) (> (gEgo cel:) 0)))
				)
				(= temp0 (global113 loop:))
				(if
					(gEgo
						inRect:
							(+ (global113 x:) [local3 temp0])
							(+ (global113 y:) [local7 temp0])
							(+ (global113 x:) [local11 temp0])
							(+ (global113 y:) [local15 temp0])
					)
					(gSFX number: (proc0_20 25) loop: 1 priority: 14 play:)
					(gTObj noWidth: 1)
					(Talk 111 4) ; "Kill! Kill! Kill!"
					(SetScore 0 0 (- 0 (- 4 global108)))
					(if (>= (++ local2) 3)
						(= local1 1)
						(monk1 setMotion: 0 setAvoider: 0)
						(monk2 setMotion: 0 setAvoider: 0)
						(monk3 setMotion: 0 setAvoider: 0)
						(gEgo setScript: 0)
						(DisposeScript 912)
						(DisposeScript 972)
						(DisposeScript 985)
						(self setScript: (ScriptID 134 0)) ; egoDies
					)
				)
			)
		)
	)
)

(instance monkWarning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				(Print 111 3) ; "Arthur, beware! Two of these monks are illusions, but one is deadly!"
				(self dispose:)
			)
		)
	)
)

