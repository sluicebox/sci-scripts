;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 177)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	stoneDove 0
	aphroWindow 1
	theDove 2
	doveShadow 3
	proc177_4 4
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (proc177_4)
	(gTObj tWindow: aphroWindow)
	(if (< (gEgo y:) 136)
		(aphroWindow brTop: 240 brBottom: 70)
	else
		(aphroWindow brTop: 10 brBottom: 70)
	)
	(if (< (gEgo x:) 155)
		(aphroWindow brLeft: 130 brRight: 310)
	else
		(aphroWindow brLeft: 20 brRight: 200)
	)
	(Talk &rest)
)

(instance aphroWindow of SysWindow
	(properties
		color 14
		back 8
		title {Aphrodite}
		brTop 100
		brLeft 110
		brBottom 140
		brRight 240
	)
)

(instance stoneDove of Rgn
	(properties)

	(method (init)
		(Load rsSCRIPT 189)
		(super init:)
		(if (IsFlag 203)
			(theDove init: setScript: flyingDove)
			(if (not (theDove script:))
				(switch gCurRoomNum
					(75
						(theDove init: setScript: (ScriptID 190 0)) ; doveMad
					)
					(76
						(theDove init: setScript: (ScriptID 190 0)) ; doveMad
					)
					(77
						(if (!= gPrevRoomNum 76)
							(theDove init: setScript: (ScriptID 190 0)) ; doveMad
						)
					)
					(78
						(if (and (IsFlag 192) (!= gPrevRoomNum 75))
							(theDove init: setScript: (ScriptID 190 0)) ; doveMad
						)
						(if (and (not (IsFlag 192)) (!= gPrevRoomNum 77))
							(theDove init: setScript: (ScriptID 190 0)) ; doveMad
						)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (IsFlag 204)
			(theDove setScript: flyingDove)
			(ClearFlag 204)
			(SetFlag 203)
		)
		(if (IsFlag 218)
			(ClearFlag 218)
			(DisposeScript 189)
		)
		(if (IsFlag 220)
			(ClearFlag 220)
			(DisposeScript 190)
		)
		(if (and (IsFlag 203) (not (theDove script:)))
			(switch gCurRoomNum
				(78
					(if (< global194 122)
						(theDove setScript: flyingDove)
					)
				)
				(77
					(if (< 122 global194 265)
						(theDove setScript: flyingDove)
					)
				)
				(75
					(if (< 122 global194 211)
						(theDove setScript: flyingDove)
					)
				)
			)
		)
		(if (> global194 1)
			(-- global194)
		)
		(if (and (> local4 0) (== (-- local4) 1))
			(= local4 0)
			(theDove setScript: (ScriptID 190 0)) ; doveMad
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'use,deliver,throw,send/dove')
				(SetFlag 207)
				(if (gEgo has: 10) ; lamb | dove
					(if (not (IsFlag 207))
						(Print 177 0) ; "It rests in your hand, doing nothing unusual for a stone dove. You may as well put it away again."
					else
						(SetFlag 203)
						(SetFlag 204)
						(PutItem 10) ; lamb | dove
						(if (== gCurRoomNum 75)
							(SetFlag 192)
						)
					)
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'look/dove')
				(cond
					((theDove script:)
						(Print 177 1) ; "The dove leads you on. Do not lose sight of it!"
					)
					(global194
						(Print 177 2) ; "You fool, Arthur! You will lose the dove! Hurry after it!"
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((and global194 (Said 'draw/blade'))
				(= global125 2)
				(Print 177 3) ; "By all that is sacred, King Arthur, go where the dove leads you and forget all else!"
			)
			((Said 'get/dove')
				(Print 177 4) ; "OK. Here."
				(gEgo get: 10) ; lamb | dove
			)
		)
	)
)

(instance theDove of Act
	(properties
		view 175
		signal 16384
		illegalBits 0
	)

	(method (init)
		(super init:)
		(= local4 0)
		(doveShadow init: setPri: 1)
	)

	(method (dispose)
		(super dispose:)
		(= global109 0)
		(doveShadow dispose:)
	)

	(method (doit)
		(super doit:)
		(if (not (IsFlag 211))
			(if global194
				(= global109 6)
			)
			(if (< 0 global194 42)
				(User canControl: 0)
				(User canInput: 0)
			)
			(if (!= global198 z)
				(if (> z global198)
					(-- z)
				else
					(++ z)
					(if local0
						(++ z)
					)
				)
			)
			(if (== view 175)
				(cond
					((< heading 112)
						(= loop 6)
					)
					((> heading 248)
						(= loop 5)
					)
					((> heading 180)
						(= loop 1)
					)
					(else
						(= loop 2)
					)
				)
			)
			(if
				(and
					(not local1)
					(== gCurRoomNum 78)
					(> global194 1)
					(not (gEgo script:))
				)
				(if (and (< y 148) (gEgo inRect: 48 47 124 98))
					(HandsOff)
					(== local1 1)
					(gEgo setMotion: MoveTo 143 62)
				)
				(if (> (gEgo y:) 161)
					(= local3 161)
					(if (and (== gCurRoomNum 78) (< 99 (gEgo x:) 190))
						(= local2 81)
						(= local3 148)
						(if (> (gEgo x:) 144)
							(= local2 205)
						)
					)
				)
				(if (and (> (gEgo y:) 161) (< 99 (gEgo x:) 190))
					(HandsOff)
					(gEgo illegalBits: 0)
					(== local1 1)
					(if (> (gEgo x:) 144)
						(gEgo setMotion: MoveTo 205 148)
					else
						(gEgo setMotion: MoveTo 81 148)
					)
				)
			)
		)
	)
)

(instance doveShadow of Act
	(properties
		view 175
		signal 16384
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(self
			posn:
				(- (theDove x:) (/ (theDove z:) 4))
				(+ (theDove y:) (/ (theDove z:) 5))
				0
			cel: (theDove cel:)
		)
		(= loop (+ (theDove loop:) 2))
		(self
			setPri:
				(if (and (== gCurRoomNum 76) (doveShadow inRect: -20 104 266 300))
					3
				else
					1
				)
		)
		(if
			(and
				(not (User canControl:))
				(== (gEgo view:) 0)
				(or
					(and (== (theDove script:) flyingDove) (< 5 global199 63))
					(IsFlag 297)
				)
			)
			(Face gEgo self)
		)
	)
)

(instance flyingDove of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(theDove init: setCycle: Fwd)
				(if (or (IsFlag 210) global194)
					(self changeState: 5)
				else
					(HandsOff)
					(= local2 (gEgo x:))
					(= local3 (gEgo y:))
					(if (< (gEgo x:) 65)
						(= local2 65)
					)
					(if (> (gEgo x:) 254)
						(= local2 254)
					)
					(if (< (gEgo y:) 74)
						(= local3 74)
					)
					(if (> (gEgo y:) 161)
						(= local3 161)
						(if (and (== gCurRoomNum 78) (< 99 (gEgo x:) 190))
							(= local2 81)
							(= local3 148)
							(if (> (gEgo x:) 144)
								(= local2 205)
							)
						)
					)
					(switch gCurRoomNum
						(78
							(if (gEgo inRect: 0 0 100 70)
								(= local2 65)
								(= local3 54)
							)
						)
						(75
							(cond
								((gEgo inRect: 178 160 312 189)
									(= local2 226)
									(= local3 152)
								)
								((gEgo inRect: 144 157 179 189)
									(= local2 124)
									(= local3 154)
								)
							)
						)
						(76
							(cond
								((gEgo inRect: 256 111 500 131)
									(= local2 271)
									(= local3 145)
								)
								((gEgo inRect: 89 54 113 67)
									(= local2 47)
									(= local3 82)
								)
							)
						)
					)
					(if (or (!= (gEgo x:) local2) (!= (gEgo y:) local3))
						(gEgo
							illegalBits: 0
							setMotion: MoveTo local2 local3 self
						)
					else
						(self cue:)
					)
				)
			)
			(1
				(= global109 6)
				(if (not (gEgo loop:))
					(gEgo loop: 1)
				else
					(gEgo loop: 0)
				)
				(gEgo view: 70 setCycle: End self)
			)
			(2
				(theDove
					init:
					view: 178
					cel: 0
					setLoop: 6
					posn: (- (gEgo x:) 14) (- (gEgo y:) 2) 34
				)
				(if (gEgo loop:)
					(theDove posn: (+ (gEgo x:) 13) (- (gEgo y:) 2) 37)
				)
				(RedrawCast)
				(Print 177 5) ; "The stone dove feels oddly warm. 'Tis changing! By the power of Aphrodite, it turns to a living dove within your very hands!"
				(SetScore 0 0 5)
				(gEgo illegalBits: -32768 setCycle: Beg self)
				(theDove view: 175 setLoop: 5)
				(= global198 65)
				(theDove
					setMotion: MoveTo (- (gEgo x:) 62) (gEgo y:) self
				)
			)
			(3
				(gEgo setLoop: -1)
				(gEgo loop: 3 view: 0)
			)
			(4
				(if (!= gCurRoomNum 78)
					(proc177_4 177 6) ; "Follow my dove and you shall have your soul's desire."
				)
				(doveShadow setScript: (ScriptID 189 0) 0 1) ; circleEgo
			)
			(5
				(gEgo setLoop: -1 setCycle: Walk)
				(theDove setCycle: Fwd)
				(if (not global194)
					(HandsOff)
					(theDove setLoop: 5)
					(switch gCurRoomNum
						(76
							(cond
								((> (theDove x:) 228)
									(= local0 356)
									(= global198 80)
									(theDove setMotion: MoveTo 228 138 self)
								)
								((> (theDove x:) 147)
									(= local0 328)
									(= global198 75)
									(theDove setMotion: MoveTo 147 172 self)
								)
								(else
									(= local0 284)
									(= global198 75)
									(if (< (theDove x:) 50)
										(theDove setLoop: 6)
									)
									(theDove setMotion: MoveTo 50 134 self)
								)
							)
						)
						(77
							(cond
								((> (theDove x:) 226)
									(= local0 234)
									(= global198 69)
									(theDove setMotion: MoveTo 226 80 self)
								)
								((> (theDove x:) 117)
									(= local0 197)
									(= global198 50)
									(theDove setMotion: MoveTo 117 98 self)
								)
								(else
									(= local0 163)
									(= global198 57)
									(if (< (theDove x:) 93)
										(theDove setLoop: 6)
									)
									(theDove setMotion: MoveTo 93 166 self)
								)
							)
						)
						(75
							(cond
								((> (theDove x:) 253)
									(= local0 211)
									(= global198 60)
									(theDove setMotion: MoveTo 253 83 self)
								)
								((> (theDove x:) 195)
									(= local0 192)
									(= global198 70)
									(theDove setMotion: MoveTo 195 80 self)
								)
								(else
									(= local0 141)
									(= global198 60)
									(if (< (theDove x:) 44)
										(theDove setLoop: 6)
									)
									(theDove setMotion: MoveTo 44 109 self)
								)
							)
						)
						(78
							(if (> (gEgo y:) 92)
								(= local0 76)
								(= global198 50)
								(if (< (theDove x:) 267)
									(theDove setLoop: 6)
								)
								(theDove setMotion: MoveTo 267 92 self)
							else
								(= local0 42)
								(= global198 37)
								(if (< (theDove x:) 167)
									(theDove setLoop: 6)
								)
								(theDove setMotion: MoveTo 167 142 self)
							)
						)
					)
				else
					(HandsOn)
					(self cue:)
				)
			)
			(6
				(if local0
					(= global194 local0)
					(= local0 0)
					(gEgo setLoop: -1)
					(HandsOn)
				)
				(switch gCurRoomNum
					(76
						(cond
							((> global194 328)
								(self changeState: 7)
							)
							((> global194 294)
								(self changeState: 8)
							)
							((> global194 284)
								(self changeState: 9)
							)
							((> global194 265)
								(self changeState: 10)
							)
							(else
								(theDove dispose:)
								(self dispose:)
							)
						)
					)
					(77
						(cond
							((or (> global194 265) (IsFlag 192))
								(theDove dispose:)
								(self dispose:)
							)
							((> global194 234)
								(self changeState: 12)
							)
							((> global194 197)
								(self changeState: 13)
							)
							((> global194 163)
								(self changeState: 14)
							)
							((> global194 122)
								(self changeState: 15)
							)
							(else
								(theDove dispose:)
								(self dispose:)
							)
						)
					)
					(75
						(cond
							((or (> global194 211) (not (IsFlag 192)))
								(theDove dispose:)
								(self dispose:)
							)
							((> global194 192)
								(self changeState: 17)
							)
							((> global194 162)
								(self changeState: 18)
							)
							((> global194 141)
								(self changeState: 19)
							)
							((> global194 122)
								(self changeState: 20)
							)
							(else
								(theDove dispose:)
								(self dispose:)
							)
						)
					)
					(78
						(cond
							((> global194 122)
								(theDove dispose:)
								(self dispose:)
							)
							((> global194 76)
								(self changeState: 22)
							)
							((> global194 42)
								(self changeState: 23)
							)
							((> global194 1)
								(self changeState: 24)
							)
							((== global194 1)
								(self changeState: 25)
							)
							(else
								(theDove dispose:)
								(self dispose:)
							)
						)
					)
					(else
						(theDove dispose:)
						(self dispose:)
					)
				)
			)
			(7
				(theDove posn: 228 138 80 setMotion: MoveTo 147 172 self)
				(= global198 75)
			)
			(8
				(theDove posn: 147 172 75 setMotion: MoveTo 79 116 self)
				(= global198 90)
			)
			(9
				(theDove posn: 79 116 90 setMotion: MoveTo 50 134 self)
				(= global198 75)
			)
			(10
				(theDove posn: 50 134 75 setMotion: MoveTo -7 122 self)
				(= global198 75)
			)
			(11
				(= local4 85)
				(client dispose:)
				(self dispose:)
			)
			(12
				(theDove posn: 320 100 75 setMotion: MoveTo 226 80 self)
				(= global198 69)
			)
			(13
				(theDove posn: 226 80 69 setMotion: MoveTo 117 98 self)
				(= global198 50)
			)
			(14
				(theDove posn: 117 98 50 setMotion: MoveTo 93 166 self)
				(= global198 57)
			)
			(15
				(theDove posn: 93 166 57 setMotion: MoveTo 103 247 self)
				(= global198 57)
			)
			(16
				(= local4 85)
				(client dispose:)
				(self dispose:)
			)
			(17
				(theDove posn: 253 83 60 setMotion: MoveTo 195 80 self)
				(= global198 70)
			)
			(18
				(theDove posn: 195 80 70 setMotion: MoveTo 107 105 self)
				(= global198 45)
			)
			(19
				(theDove posn: 107 105 45 setMotion: MoveTo 44 109 self)
				(= global198 60)
			)
			(20
				(theDove posn: 44 109 60 setMotion: MoveTo -12 95 self)
				(= global198 70)
			)
			(21
				(= local4 85)
				(client dispose:)
				(self dispose:)
			)
			(22
				(if (IsFlag 192)
					(theDove posn: 320 90 60)
					(if (> 122 global194 95)
						(-= global194 27)
					)
				else
					(theDove posn: 183 0 60)
				)
				(theDove setMotion: MoveTo 267 92 self)
				(= global198 50)
			)
			(23
				(theDove posn: 267 92 50 setMotion: MoveTo 167 142 self)
				(= global198 37)
			)
			(24
				(HandsOff)
				(theDove posn: 167 142 37 setMotion: MoveTo 100 87 self)
				(= global198 32)
			)
			(25
				(theDove posn: 100 87 32 setMotion: MoveTo 86 74)
				(if local1
					(gEgo illegalBits: -32768 setMotion: 0)
					(= local1 0)
				)
				(SetFlag 205)
				(ClearFlag 203)
				(ClearFlag 204)
				(self dispose:)
			)
		)
	)
)

