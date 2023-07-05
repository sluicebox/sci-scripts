;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64039)
(include sci.sh)
(use Main)
(use CueMe)
(use soFlashCyberSniff)
(use Print)
(use Game)
(use System)

(public
	oHandsOnWhenCued 0
	soExit 1
)

(local
	local0
	local1
	local2
	local3
)

(class L7Room of Room
	(properties
		oExtraPlanes 0
		oMainPlane 0
	)

	(method (init &tmp temp0)
		(if gCuees
			(gCuees release: dispose:)
			(= gCuees 0)
		)
		(if (!= ((ScriptID 64037 2) priority:) -1) ; oInvPlane
			((ScriptID 64037 2) setPri: -1) ; oInvPlane
		)
		(super init: &rest)
		(Palette 1 999) ; PalLoad
		(if (ResCheck rsPALETTE gCurRoomNum)
			(Palette 1 gCurRoomNum) ; PalLoad
		else
			(Palette 1 600) ; PalLoad
		)
		(Palette 2 0 235 100) ; PalIntensity
		(RemapColors 2 238 25) ; ByPercent
		(RemapColors 2 237 45) ; ByPercent
		(RemapColors 2 236 75) ; ByPercent
		(if ((ScriptID 64017 0) test: 158) ; oFlags
			((ScriptID 90 0) dispose:) ; oTravelScreen
		)
		(if ((ScriptID 64040 2) oPlane:) ; L7TalkWindow
			((ScriptID 64040 2) dispose:) ; L7TalkWindow
		)
	)

	(method (dispose &tmp temp0 temp1)
		(if oExtraPlanes
			(while (oExtraPlanes size:)
				(= temp0 (oExtraPlanes at: 0))
				(self deleteRoomPlane: temp0)
			)
			(oExtraPlanes dispose:)
			(= oExtraPlanes 0)
		)
		(proc64896_13)
		(gMessager kill:)
		(super dispose: &rest)
	)

	(method (addRoomPlane param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(Prints {improper call of addRoomPlane. tproom.sc djm})
			(return)
		)
		(= temp0 plane)
		(= temp1 (plane priority:))
		(gCurRoom plane: param1)
		(if (not oExtraPlanes)
			(= oExtraPlanes (Set new:))
		)
		(oExtraPlanes addToEnd: param1)
		(if (not oMainPlane)
			(= oMainPlane temp0)
		)
		(temp0 disable:)
		(param1 init: setPri: (++ temp1))
	)

	(method (deleteRoomPlane param1)
		(if (or (not argc) (not param1) (not oExtraPlanes) (not oMainPlane))
			(Prints {improper call of deleteRoomPlane. tproom.sc djm})
			(return)
		)
		(oExtraPlanes delete: param1)
		(if (== param1 plane)
			(if (oExtraPlanes size:)
				(= plane (KList 8 (oExtraPlanes last:))) ; NodeValue
			else
				(= plane oMainPlane)
				(= oMainPlane 0)
			)
			(plane enable:)
		)
		(param1 dispose:)
	)

	(method (gimme))

	(method (exitRoom param1 param2 param3 param4)
		(if (< argc 3)
			(PrintDebug
				{You have to pass all three arguments.\ntheRoom, theX, and theY. SRC l7room.sc.}
			)
			(return)
		else
			(= local0 param1)
			(= local1 param2)
			(= local2 param3)
			(if (> argc 3)
				(= local3 param4)
			else
				(= local3 0)
			)
			(self setScript: soExit)
		)
	)
)

(instance oHandsOnWhenCued of CueMe
	(properties)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance soExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: local1 local2 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(if local3
					(= cycles 1)
				else
					(gEgo walkTo: local1 local2 self 0 0 0)
				)
			)
			(2
				(gCurRoom newRoom: local0)
				(self dispose:)
			)
		)
	)
)

