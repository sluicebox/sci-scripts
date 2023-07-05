;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Array)
(use Game)
(use Actor)
(use System)

(public
	interrogation 0
	IsNotFlag 1
	IsFlag 2
	SetFlag 3
	ClearFlag 4
	IsInterrogationFlag 5
	SetInterrogationFlag 6
	ClearInterrogationFlag 7
	IsNotInterrogationFlag 8
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (IsNotFlag param1)
	(return (not (& [global127 (/ param1 16)] (>> $8000 (mod param1 16)))))
)

(procedure (IsFlag param1)
	(return (& [global127 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global127 (/ param1 16)]
		(| [global127 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global127 (/ param1 16)]
		(& [global127 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (IsNotInterrogationFlag param1)
	(return (not (& [global182 (/ param1 16)] (>> $8000 (mod param1 16)))))
)

(procedure (IsInterrogationFlag param1)
	(return (& [global182 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetInterrogationFlag param1 &tmp temp0)
	(= temp0 (IsInterrogationFlag param1))
	(= [global182 (/ param1 16)]
		(| [global182 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearInterrogationFlag param1 &tmp temp0)
	(= temp0 (IsInterrogationFlag param1))
	(= [global182 (/ param1 16)]
		(& [global182 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(instance interrogation of Room
	(properties
		picture 98
		style 14
	)

	(method (init &tmp temp0)
		(gTheIconBar erase:)
		(if
			(or
				(OneOf global178 12 2 45 46)
				(and (== gDay 10) (== global178 8))
				(IsHiRes)
			)
			(= picture 99)
			(Load rsPIC 99)
		else
			(Load rsPIC 98)
		)
		(ScriptID 51) ; GKTeller
		(ScriptID 920) ; Teller
		(ScriptID
			(switch global178
				(2 1050)
				(6 1050)
				(8 1051)
				(26 1051)
				(34 1052)
				(11 1052)
				(5 1053)
				(25 1053)
				(32 1054)
				(27 1054)
				(40 1055)
				(12 1055)
				(10 1056)
				(46 1056)
				(45 1057)
				(else 1050)
			)
		)
		(super init:)
		(for ((= temp0 37)) (< temp0 40) ((++ temp0))
			(SetFlag temp0)
		)
		(if (not global176)
			(= global176 (IntArray new: 15))
		)
		(self setScript: roomScript)
	)

	(method (dispose)
		(UnLoad
			129
			(if
				(or
					(OneOf global178 12 2 45 46)
					(and (== gDay 10) (== global178 8))
					(IsHiRes)
				)
				99
			else
				98
			)
		)
		(if local3
			(UnLoad 128 local3)
			(= local3 0)
		)
		(if local4
			(UnLoad 128 local4)
			(= local4 0)
		)
		(DisposeScript 51)
		(DisposeScript 920)
		(DisposeScript 941)
		(DisposeScript 1100)
		(DisposeScript
			(switch global178
				(2 1050)
				(6 1050)
				(8 1051)
				(26 1051)
				(34 1052)
				(11 1052)
				(5 1053)
				(25 1053)
				(32 1054)
				(27 1054)
				(40 1055)
				(12 1055)
				(10 1056)
				(46 1056)
				(45 1057)
				(else 1050)
			)
		)
		(UnLoad 128 970)
		(gGame setCursor: local2)
		(SetCursor 0 0 319 155)
		(if (GK keepBar:)
			(gTheIconBar draw: updateScore:)
		)
		(super dispose:)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local2
					(gGame
						setCursor:
							((ScriptID 0 1) view: 9999 loop: 0 cel: 0 yourself:) ; globeCursor
					)
				)
				(SetCursor -2)
				(= local0
					(switch global178
						(2
							((ScriptID 1050 0) init:) ; grace
						)
						(6
							((ScriptID 1050 1) init:) ; sarge
						)
						(8
							((ScriptID 1051 0) init:) ; mosely
						)
						(26
							((ScriptID 1051 1) init:) ; granny
						)
						(34
							((ScriptID 1052 0) init:) ; bartender
						)
						(11
							((ScriptID 1052 1) init:) ; willy
						)
						(5
							((ScriptID 1053 0) init:) ; malia
						)
						(25
							((ScriptID 1053 1) init:) ; drJohn
						)
						(32
							((ScriptID 1054 0) init:) ; graveman
						)
						(27
							((ScriptID 1054 1) init:) ; moonbeam
						)
						(40
							((ScriptID 1055 0) init:) ; hartridge
						)
						(12
							((ScriptID 1055 1) init:) ; cazaunoux
						)
						(10
							((ScriptID 1056 0) init:) ; crash
						)
						(46
							((ScriptID 1056 1) init:) ; wolfgang
						)
						(45
							((ScriptID 1057 0) init:) ; gerde
						)
						(else 0)
					)
				)
				(if
					(or
						(OneOf global178 12 2 45 46)
						(and (== gDay 10) (== global178 8))
						(IsHiRes)
					)
					((= local1 (View new:)) view: 970 loop: 0 cel: 0 x: 2 y: 0)
				)
				(if
					(or
						(OneOf global178 2 45 46)
						(and (== gDay 10) (== global178 8))
					)
					(local1 view: 9701)
				)
				(if (== global178 12)
					(local1 view: 9702)
				)
				(if (IsHiRes)
					(local1 view: (+ 10000 (local1 view:)))
				)
				(if
					(or
						(OneOf global178 12 2 45 46)
						(and (== gDay 10) (== global178 8))
						(IsHiRes)
					)
					(local1 init:)
				else
					(Load rsVIEW (= local3 970))
				)
				(= seconds 1)
			)
			(1
				(if local0
					(Load rsVIEW (= local4 ((local0 view:) view:)))
					(= cycles 1)
				else
					(gMessager say: 8 0 117 0 self 50) ; "Hey, what's going on? There's nobody here but me."
				)
			)
			(2
				(if local0
					(local0 doVerb:)
				else
					(++ state)
					(= cycles 20)
				)
			)
			(3
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 4))
					(Palette 2 0 255 temp0) ; PalIntensity
					(FrameOut)
				)
				(if local0
					(local0 dispose:)
				)
				(if local1
					(local1 dispose:)
					(= local1 0)
				)
				(gCurRoom drawPic: 99 0)
				(= cycles 3)
			)
			(4
				(Palette 2 0 255 100) ; PalIntensity
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

