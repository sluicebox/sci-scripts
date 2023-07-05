;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use TPSound)
(use DialogPlane)
(use CueMe)
(use PushButton)
(use soFlashCyberSniff)
(use Str)
(use Motion)
(use Actor)
(use System)

(public
	oDildo 0
	oDildoScore 1
	soDildo 2
	proc50_3 3
)

(local
	local0
)

(procedure (proc50_3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp6 (MakeMessageText 0 0 62 1 14))
	(= temp5 (Str format: (temp6 data:) global264 32))
	(temp6 dispose:)
	(= temp0 global289)
	(= global289 60690)
	(= temp1 global291)
	(= global291 1)
	(= temp4 global290)
	(= global290 60620)
	(= temp2 global276)
	(= global276 60613)
	(= temp3 global277)
	(= global277 60614)
	(TextDialog temp5 (MakeMessageText 0 0 70 1 14) (MakeMessageText 0 0 61 1 14))
	(= global289 temp0)
	(= global291 temp1)
	(= global290 temp4)
	(= global276 temp2)
	(= global277 temp3)
)

(class Dildo of Actor
	(properties
		priority 1
		view 43401
		fixPriority 1
		destX 0
		destY 0
		nMyFlag 0
		oAltScript 0
	)

	(method (init)
		(if (== nMyFlag 0)
			(PrintDebug {Dildo without a flag, not initting!})
			(return)
		)
		(if ((ScriptID 64017 0) test: nMyFlag) ; oFlags
			(return)
		)
		(= cel 0)
		(super init: &rest)
		(self setStep: 6 30)
		(self setSpeed: 6)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (setDest param1 param2)
		(= destX param1)
		(= destY param2)
	)

	(method (doVerb)
		(gEgo setMotion: 0)
		(++ global264)
		((ScriptID 64017 0) set: nMyFlag) ; oFlags
		(self setScript: soDildo)
	)

	(method (dildoHop param1)
		(super setMotion: MoveTo destX destY param1)
	)

	(method (dispose)
		(= view 43401)
		(= cel (= loop 0))
		(self setScalePercent: 100)
		(= oAltScript 0)
		(super dispose: &rest)
	)
)

(instance soDildo of Script
	(properties)

	(method (changeState newState &tmp [temp0 7])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gOMusic1 isPlaying:)
					(= local0 1)
					(gOMusic1 pause: 1)
				else
					(= local0 0)
				)
				(oShortSound setRelVol: 400 playSound: 104 coMusicDone)
				(if (client respondsTo: #oAltScript)
					(if (== (client oAltScript:) 0)
						(client setCycle: Walk dildoHop: self)
					else
						(self setScript: (client oAltScript:) self)
					)
				)
			)
			(1
				(client hide:)
				(gGame handsOn:)
				(proc50_3)
				(if (oShortSound isPlaying:)
					(oShortSound stop:)
					(if ((ScriptID 64017 0) test: 295) ; oFlags
						((ScriptID 15 1) pause: 0) ; oCreditMusic
					else
						(gOMusic1 pause: 0)
					)
				)
				(if (== global264 32)
					(CopyWinningWallpaper 7)
				)
				(client dispose:)
			)
		)
	)
)

(instance coMusicDone of CueMe
	(properties)

	(method (cue)
		(if local0
			(if ((ScriptID 64017 0) test: 295) ; oFlags
				((ScriptID 15 1) pause: 0) ; oCreditMusic
			else
				(gOMusic1 pause: 0)
			)
		)
	)
)

(instance oDildo of Dildo
	(properties)
)

(instance oDildoScore of TextItem
	(properties
		back 84
		priority 600
		x 20
		y 400
		fixPriority 1
		font 2510
		border 6
	)

	(method (init)
		(if (== global264 1)
			(= text (Str format: {1 DILDO FOUND\nOUT OF %d.} 32))
		else
			(= text (Str format: {%d DILDOS FOUND\nOUT OF %d.} global264 32))
		)
		(super init: &rest)
		(self setScale:)
		(= scaleX (MulDiv 128 120 nWidth))
		(= scaleY (MulDiv 128 40 nHeight))
	)
)

(instance oShortSound of TPSound
	(properties)
)

