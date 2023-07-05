;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45950)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Print)
(use Feature)
(use Actor)
(use System)

(public
	rm45950 0
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
)

(instance rm45950 of ScaryRoom
	(properties
		stepSound 4
	)

	(method (init &tmp temp0 temp1)
		(SetFlag 139)
		(SetFlag 121)
		(ClearFlag 151)
		(ClearFlag 212)
		(ClearFlag 410)
		(= gChapter 7)
		(SetFlag 145)
		(SetFlag 117)
		(= global115 0)
		(if (IsFlag 135)
			(proc1111_6 0 0)
		)
		(if
			(and
				(not (IsFlag 151))
				(not (IsFlag 135))
				(not (IsFlag 390))
				(not (IsFlag 130))
			)
			(drainCleaner
				view: 10751
				loop: 0
				cel: 0
				init:
				x: 222
				y: 102
				setHotspot: 4 3 ; Do, Move
				approachVerbs: 0
			)
		)
		(if (gCast contains: gEgo)
			(gEgo dispose:)
		)
		(if (gEgo has: 10) ; invBrooch
			((gInventory at: 10) view: 9871 loop: 0 cel: 0 verb: 37) ; invBrooch
			(SetFlag 81)
		)
		(if (and (gEgo has: 16) (== gPrevRoomNum 46790)) ; invSpellBook
			(gEgo put: 16) ; invSpellBook
		)
		(if (not (gEgo has: 5)) ; invHammer
			(gEgo get: 5) ; invHammer
		)
		(= temp0 (Str newWith: 2 {01}))
		(= temp1 (Str newWith: 128 gCurSaveDir))
		(temp1 cat: {chase.dat})
		(cond
			((IsFlag 135)
				(ClearFlag 121)
				(gCurRoom setScript: playBack)
			)
			((and (FileIO fiEXISTS (temp1 data:)) (IsFlag 370))
				(FileIO fiUNLINK (temp1 data:))
				((ScriptID 45951 2) open: 2 writeString: temp0) ; chase_dat
			)
			((IsFlag 134)
				((ScriptID 45951 2) delete: open: 2 writeString: temp0) ; chase_dat
				(ClearFlag 134)
			)
			((not (FileIO fiEXISTS (temp1 data:)))
				((ScriptID 45951 2) open: 2 writeString: temp0) ; chase_dat
			)
			((IsFlag 150)
				(ClearFlag 150)
				(cond
					((IsFlag 130)
						(proc45951_4)
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
					)
					(((ScriptID 45951 2) handle:) ; chase_dat
						((ScriptID 45951 2) seek: 0 0 writeString: temp0) ; chase_dat
					)
					(else
						((ScriptID 45951 2) open: 2 writeString: temp0) ; chase_dat
					)
				)
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp1 dispose:)
		(temp0 dispose:)
		(doorExit init: 1 approachVerbs: 0)
		(if (== gPrevRoomNum 46790)
			(= local2 1)
		)
		(cond
			((IsFlag 135)
				(if (and (not (IsFlag 130)) (not local2))
					(= picture -1)
				)
			)
			((not (IsFlag 130))
				(if (gCast contains: drainCleaner)
					(drainCleaner hide:)
				)
				(= picture -1)
				(ClearFlag 390)
				(gCurRoom setScript: sChaseBegin)
			)
			(else
				(= picture 10751)
				(gCurRoom setScript: enterRoom)
			)
		)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
	)

	(method (dispose &tmp temp0)
		(if (and (not (IsFlag 135)) (not local4))
			(= temp0 (Str newWith: 3 {99\r\n}))
			((ScriptID 45951 2) writeString: temp0 close:) ; chase_dat
			(temp0 dispose:)
		)
		(ClearFlag 139)
		(if (IsFlag 390)
			(SetFlag 121)
		)
		(super dispose:)
	)
)

(instance playBack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (IsFlag 390)
					(SetFlag 121)
				)
				(if (not ((ScriptID 45951 2) handle:)) ; chase_dat
					((ScriptID 45951 2) open: 1) ; chase_dat
				)
				(if local3
					(= local3 0)
				else
					(proc45951_3)
				)
				(switch global179
					(0
						(gCurRoom setScript: playNextRoom)
					)
					(1
						(-- state)
						(= cycles 1)
					)
					(2
						(ClearFlag 390)
						(self setScript: sChaseBegin self)
					)
					(3
						(self setScript: sStrangleDeath self)
					)
					(4
						(self setScript: sAcidInFace self)
					)
					(5
						(self setScript: sGetSBookDeath self)
					)
					(6
						(self setScript: pokeDon self)
					)
					(7
						(self setScript: sHammerOnDon self)
					)
					(8
						(self setScript: recoverHammer self)
					)
					(9
						(self setScript: thumpDonWithHammer self)
					)
					(10
						(self setScript: sDonRecovers self)
					)
					(11
						(self setScript: getBook self)
					)
					(12
						(self setScript: stabDon self)
					)
					(13
						(self setScript: sExitDoor self)
					)
					(14
						(self setScript: outtaHere self)
					)
					(15
						(self setScript: grabAdrienne self)
					)
					(16
						(gCurRoom setScript: tryAgain)
					)
					(99
						(gCurRoom setScript: playNextRoom)
					)
				)
			)
			(1
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance playNextRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc45951_3)
				(proc45951_3)
				(if (== global179 2)
					(global114 play: 10671)
					(gCurRoom newRoom: 46030)
				else
					(SetFlag 150)
					(gCurRoom newRoom: 46790)
				)
			)
		)
	)
)

(instance enterPlayBack of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(= temp0 (Str newWith: 2 {01}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
					(= local0 0)
					(if (or (IsFlag 135) (not (gEgo has: 16))) ; invSpellBook
						(spellBook
							setHotspot: 4 3 ; Do, Move
							view: 10751
							loop: 0
							x: 143
							y: 102
							init:
							setPri: 200
							approachVerbs: 0
						)
					)
					(proc1111_7 6190 115 30 0)
					(gGame handsOn:)
				)
				(1
					(gGame handsOff:)
					(= local0 1)
					(proc1111_7 6210 91 17 0)
					(changeTo10731 doit:)
				)
				(2)
				(3
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: grabAdrienne)
					)
				)
			)
		)
	)
)

(instance sChaseBegin of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(= global165 1)
			(SetFlag 131)
			(ClearFlag 370)
			(ClearFlag 154)
			(ClearFlag 123)
			(if (not (== gPrevRoomNum 900))
				(if (gEgo has: 17) ; invXmasOrn
					(SetFlag 355)
				)
				(if (gEgo has: 19) ; invCutter
					(SetFlag 304)
				)
				(if (gEgo has: 15) ; invBeads
					(SetFlag 354)
				)
				(if (gEgo has: 14) ; invCrucifix
					(SetFlag 356)
				)
			)
			(if (and (IsFlag 355) (not (gEgo has: 17))) ; invXmasOrn
				(gEgo get: 17) ; invXmasOrn
			)
			(if (and (IsFlag 304) (not (gEgo has: 19))) ; invCutter
				(gEgo get: 19) ; invCutter
			)
			(if (and (IsFlag 354) (not (gEgo has: 15))) ; invBeads
				(gEgo get: 15) ; invBeads
			)
			(if (and (IsFlag 356) (not (gEgo has: 14))) ; invCrucifix
				(gEgo get: 14) ; invCrucifix
			)
			(if (and (not (IsFlag 355)) (gEgo has: 17)) ; invXmasOrn
				(gEgo put: 17) ; invXmasOrn
			)
			(if (and (not (IsFlag 356)) (gEgo has: 14)) ; invCrucifix
				(gEgo put: 14) ; invCrucifix
			)
			(if (and (not (IsFlag 354)) (gEgo has: 15)) ; invBeads
				(gEgo put: 15) ; invBeads
			)
			(if (and (not (IsFlag 304)) (gEgo has: 19)) ; invCutter
				(gEgo put: 19) ; invCutter
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {02}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					else
						(ClearFlag 121)
					)
					(= global165 1)
					(SetFlag 131)
					(ClearFlag 370)
					(ClearFlag 154)
					(ClearFlag 130)
					(ClearFlag 131)
					(ClearFlag 132)
					(ClearFlag 133)
					(ClearFlag 140)
					(ClearFlag 141)
					(ClearFlag 142)
					(ClearFlag 143)
					(ClearFlag 148)
					(ClearFlag 149)
					(ClearFlag 150)
					(ClearFlag 219)
					(ClearFlag 157)
					(ClearFlag 212)
					(ClearFlag 213)
					(ClearFlag 224)
					(ClearFlag 227)
					(ClearFlag 67)
					(ClearFlag 59)
					(ClearFlag 311)
					(ClearFlag 410)
					(ClearFlag 414)
					(ClearFlag 415)
					(ClearFlag 123)
					(if (not (== gPrevRoomNum 900))
						(if (gEgo has: 17) ; invXmasOrn
							(SetFlag 355)
						)
						(if (gEgo has: 19) ; invCutter
							(SetFlag 304)
						)
						(if (gEgo has: 15) ; invBeads
							(SetFlag 354)
						)
						(if (gEgo has: 14) ; invCrucifix
							(SetFlag 356)
						)
					)
					(if (and (IsFlag 355) (not (gEgo has: 17))) ; invXmasOrn
						(gEgo get: 17) ; invXmasOrn
					)
					(if (and (IsFlag 304) (not (gEgo has: 19))) ; invCutter
						(gEgo get: 19) ; invCutter
					)
					(if (and (IsFlag 354) (not (gEgo has: 15))) ; invBeads
						(gEgo get: 15) ; invBeads
					)
					(if (and (IsFlag 356) (not (gEgo has: 14))) ; invCrucifix
						(gEgo get: 14) ; invCrucifix
					)
					(if (and (not (IsFlag 356)) (gEgo has: 14)) ; invCrucifix
						(gEgo put: 14) ; invCrucifix
					)
					(if (and (not (IsFlag 355)) (gEgo has: 17)) ; invXmasOrn
						(gEgo put: 17) ; invXmasOrn
					)
					(if (and (not (IsFlag 304)) (gEgo has: 19)) ; invCutter
						(gEgo put: 19) ; invCutter
					)
					(if (and (not (IsFlag 354)) (gEgo has: 15)) ; invBeads
						(gEgo put: 15) ; invBeads
					)
					(if (and (not (IsFlag 356)) (gEgo has: 14)) ; invCrucifix
						(gEgo put: 14) ; invCrucifix
					)
					(if (not (gEgo has: 4)) ; invPoker
						(gEgo get: 4) ; invPoker
					)
					(if gDebugging
						(gEgo get: 4 5) ; invPoker
						(if (gEgo has: 16) ; invSpellBook
							(gEgo put: 16) ; invSpellBook
						)
					)
					(= cycles 2)
				)
				(1
					(if local2
						(self cue:)
					else
						(PlayVMD 0 {5950.vmd} 0) ; Open
						(gCurRoom picture: 10751)
						(proc26_0 5950 self)
					)
				)
				(2
					(gCurRoom picture: -1)
					(proc1111_7 5950 -19 -27 0 -1 1)
					(drainCleaner init: setHotspot: 4 3) ; Do, Move
					(spellBook
						view: 10751
						x: 143
						y: 102
						loop: 0
						init:
						setPri: 132
					)
					(changeTo10751 doit:)
				)
				(3
					(spellBook setPri: 200)
				)
				(4
					(if (IsFlag 135)
						(= local3 1)
						(proc45951_3)
						(if (!= global179 3)
							(self dispose:)
						)
					else
						(gGame handsOn:)
					)
				)
				(5
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: sStrangleDeath)
					)
				)
			)
		)
	)
)

(instance sStrangleDeath of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 135))
					(= temp0 (Str newWith: 2 {03}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
				)
				(proc1111_7 5960 109 35 0 100 1)
				(changeTo10731 doit:)
			)
			(1
				(if (IsFlag 135)
					(self dispose:)
				else
					(gCurRoom setScript: tryAgain)
				)
			)
		)
	)
)

(instance sAcidInFace of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 227)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= local0 0)
					(spellBook
						setHotspot: 4 3 ; Do, Move
						init:
						setPri: 200
						approachVerbs: 0
					)
					(SetFlag 227)
					(proc1111_7 5970 -20 -5 0 140)
					(changeTo10731 doit:)
				)
				(1
					(drainCleaner dispose:)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gGame handsOn:)
					)
				)
				(3
					(gGame handsOff:)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: sDonRecovers)
					)
				)
			)
		)
	)
)

(instance sGetSBookDeath of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(gEgo get: 16) ; invSpellBook
			((ScriptID 45951 1) doit:) ; checkInv
			(SetFlag 150)
			(= global159 45950)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {05}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 5980 -13 -7 0 -1 1)
					(changeTo10751 doit:)
				)
				(1
					(gEgo get: 16) ; invSpellBook
					(spellBook dispose:)
				)
				(2
					((ScriptID 45951 1) doit: self) ; checkInv
				)
				(3
					(SetFlag 150)
					(= global159 45950)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46790)
					)
				)
			)
		)
	)
)

(instance pokeDon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 150)
			(= global159 45950)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {06}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 6230 58 20 0 -1 1)
					(changeTo10751 doit:)
				)
				(1
					(SetFlag 150)
					(= global159 45950)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46790)
					)
				)
			)
		)
	)
)

(instance sHammerOnDon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 150)
			(= global159 45950)
			(self dispose:)
		)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 135))
					(= temp0 (Str newWith: 2 {07}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
				)
				(proc1111_7 6010 41 4 0 -1 1)
				(changeTo10751 doit:)
			)
			(1
				(SetFlag 150)
				(= global159 45950)
				(if (IsFlag 135)
					(self dispose:)
				else
					(gCurRoom newRoom: 46790)
				)
			)
		)
	)
)

(instance recoverHammer of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 150)
			(= global159 45950)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {08}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 6250 12 -7 0 -1 1)
					(changeTo10731 doit:)
				)
				(1
					(SetFlag 150)
					(= global159 45950)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46790)
					)
				)
			)
		)
	)
)

(instance thumpDonWithHammer of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 67)
			(gEgo put: 5) ; invHammer
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {09}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(SetFlag 67)
					(gEgo put: 5) ; invHammer
					(donFeature dispose:)
					(proc1111_7 6240 46 1 0)
					(changeTo10751 doit:)
					(= local0 0)
				)
				(1
					(if (IsFlag 135)
						(= local3 1)
						(proc45951_3)
						(if (!= global179 10)
							(self dispose:)
						)
					else
						(gGame handsOn:)
					)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: recoverHammer)
					)
				)
			)
		)
	)
)

(instance sDonRecovers of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {10}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 9309 29 -21 0)
					(changeTo10751 doit:)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: tryAgain)
					)
				)
			)
		)
	)
)

(instance getBook of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(gEgo get: 16) ; invSpellBook
			((ScriptID 45951 1) doit:) ; checkInv
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {11}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(spellBook
						view: 10751
						loop: 0
						x: 143
						y: 102
						init:
						setPri: 200
					)
					(proc1111_7 6180 130 40 0 200)
					(changeTo10731 doit:)
					(spellBook dispose:)
				)
				(1
					(gEgo get: 16) ; invSpellBook
					((ScriptID 45951 1) doit:) ; checkInv
					(proc1111_7 6182 53 -1 0)
					(gCurRoom drawPic: 13420)
				)
				(2
					(proc1111_7 6210 91 17 0)
					(changeTo10731 doit:)
				)
				(3
					(= local0 1)
					(donFeature init: setHotspot: 4 3 11 10 27) ; Do, Move, invHammer, invPoker, invCutter
					(cond
						((IsFlag 135)
							(= local3 1)
							(proc45951_3)
							(if (!= global179 15)
								(self dispose:)
							)
						)
						((IsFlag 143)
							(gCurRoom setScript: grabAdrienne)
						)
						(else
							(gGame handsOn:)
						)
					)
				)
				(4
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: grabAdrienne)
					)
				)
			)
		)
	)
)

(instance grabAdrienne of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 150)
			(= global159 45950)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {15}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 6211 19 -21 0 -1 1)
					(changeTo10751 doit:)
				)
				(1
					(SetFlag 150)
					(= global159 45950)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46790)
					)
				)
			)
		)
	)
)

(instance stabDon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 150)
			(= global159 45950)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {12}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 6220 53 -1 0 1 1)
					(changeTo10751 doit:)
				)
				(1
					(SetFlag 150)
					(= global159 45950)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46790)
					)
				)
			)
		)
	)
)

(instance sExitDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {13}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if
						(and
							(gEgo has: 5) ; invHammer
							(not (gCast contains: spellBook))
						)
						(spellBook
							setHotspot: 4 3 ; Do, Move
							view: 10751
							loop: 0
							x: 143
							y: 102
							init:
							setPri: 200
							approachVerbs: 0
						)
					)
					(if (not (gEgo has: 5)) ; invHammer
						(proc1111_7 6251 85 -3 0 -1 1)
					else
						(proc1111_7 6200 5 35 0 -1 1)
					)
					(changeTo10731 doit:)
				)
				(1
					(global114 play: 10671)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46030)
					)
				)
			)
		)
	)
)

(instance outtaHere of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {14}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 9310 84 -15 0 -1 1)
					(changeTo10751 doit:)
					(global114 play: 10671)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46030)
					)
				)
			)
		)
	)
)

(instance tryAgain of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (IsFlag 135)
					(ClearFlag 135)
				else
					(= temp1 (Str newWith: 2 {16}))
					((ScriptID 45951 2) writeString: temp1) ; chase_dat
					(temp1 dispose:)
				)
				(gGame handsOn:)
				(if global161
					(global161 owner: -1)
					(gEgo get: (gInventory indexOf: global161))
					(gUser message: (gUser dftMessage:))
					(= global161 0)
					(gGame setCursor: gNormalCursor 1)
					(gCurrentControl select: 3 gNormalCursor)
				)
				(gUser canControl: 0 input: 0)
				(if
					(Print
						mode: 1
						addText: 0 0 0 1 1 1 40000 ; MISSING MESSAGE
						addText: 0 0 0 2 1 7 40000 ; MISSING MESSAGE
						addButton: 1 0 0 0 3 1 15 1 40000 ; MISSING MESSAGE
						addButton: 0 0 0 0 5 1 25 1 40000 ; MISSING MESSAGE
						init:
					)
					((ScriptID 45951 2) delete:) ; chase_dat
					(ClearFlag 130)
					(ClearFlag 227)
					(ClearFlag 131)
					(ClearFlag 132)
					(ClearFlag 133)
					(ClearFlag 140)
					(ClearFlag 141)
					(ClearFlag 142)
					(ClearFlag 143)
					(ClearFlag 154)
					(ClearFlag 148)
					(ClearFlag 149)
					(ClearFlag 150)
					(ClearFlag 135)
					(ClearFlag 390)
					(SetFlag 121)
					(spellBook setHotspot: 0)
					(if (not (gCast contains: drainCleaner))
						(drainCleaner
							view: 10751
							loop: 0
							cel: 0
							init:
							x: 222
							y: 102
							setHotspot: 4 3 ; Do, Move
							approachVerbs: 0
						)
					)
					(= local2 1)
					(= temp1 (Str newWith: 2 {01}))
					((ScriptID 45951 2) open: 2 writeString: temp1) ; chase_dat
					(temp1 dispose:)
					(gCurRoom setScript: sChaseBegin)
				else
					(global114 stop:)
					(= local4 1)
					(proc45951_5)
					(gCurRoom newRoom: 91) ; saveRest
				)
			)
		)
	)
)

(instance drainCleaner of View
	(properties
		x 217
		y 107
		view 10731
		loop 1
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			(proc1111_6 0 0)
			(gCurRoom setScript: sAcidInFace)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance spellBook of View
	(properties
		x 171
		y 113
		view 10731
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			(cond
				((or local0 (not (IsFlag 130)))
					(gCurRoom setScript: sGetSBookDeath)
				)
				((gEgo has: 5) ; invHammer
					(gCurRoom setScript: getBook)
				)
				(else
					(gCurRoom setScript: recoverHammer)
				)
			)
		)
	)
)

(instance donFeature of Feature
	(properties
		nsLeft 85
		nsTop 58
		nsRight 121
		nsBottom 117
		x 103
		y 87
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 4 3) ; Do, Move
				(gCurRoom setScript: grabAdrienne)
			)
			(10 ; invPoker
				(proc1111_6 0 0)
				(if (== (gCurRoom script:) sChaseBegin)
					(super doVerb: theVerb)
				else
					(gCurRoom setScript: pokeDon)
				)
			)
			(11 ; invHammer
				(proc1111_6 0 0)
				(if (IsFlag 130)
					(gCurRoom setScript: thumpDonWithHammer)
				else
					(gCurRoom setScript: sHammerOnDon)
				)
			)
			(27 ; invCutter
				(proc1111_6 0 0)
				(gCurRoom setScript: stabDon)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance changeTo10751 of Code
	(properties)

	(method (doit)
		(if (gCast contains: drainCleaner)
			(drainCleaner view: 10751 loop: 1 x: 222 y: 102)
		)
		(if (gCast contains: spellBook)
			(spellBook view: 10751 loop: 0 x: 143 y: 102)
		)
		(gCurRoom drawPic: 10751)
	)
)

(instance changeTo10731 of Code
	(properties)

	(method (doit)
		(if (gCast contains: drainCleaner)
			(drainCleaner view: 10731 loop: 1 x: 217 y: 107)
		)
		(if (gCast contains: spellBook)
			(if (IsFlag 130)
				(spellBook view: 10731 loop: 0 x: 171 y: 113)
			else
				(spellBook view: 10731 loop: 2 x: 168 y: 115)
			)
		)
		(gCurRoom drawPic: 10731)
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 99
		nsTop 5
		nsRight 185
		nsBottom 134
		y 10
		nextRoom 46030
		appYOffset 20
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(cond
				((== (gCurRoom script:) sChaseBegin)
					(proc1111_6 0 0)
					(gCurRoom setScript: sStrangleDeath)
				)
				((not (IsFlag 130))
					(gCurRoom setScript: outtaHere)
				)
				(local0
					(gCurRoom setScript: grabAdrienne)
				)
				(else
					(proc1111_6 0 0)
					(gCurRoom setScript: sExitDoor)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

